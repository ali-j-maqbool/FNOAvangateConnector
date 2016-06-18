/**
 * Avangate Service for executing the external system data translation into the common data model.
 */
package com.flexerasoftware.fnocc.service;


import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.text.SimpleDateFormat;
import java.util.*;

import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;


import com.flexerasoftware.fnocc.avangate.AvangateHmacmd;
import com.flexerasoftware.fnocc.configuration.MaterialiseProperties;
import com.flexerasoftware.fnocc.configuration.SecretKeyProperties;
import com.flexerasoftware.fnocc.injestor.AvangateController;
import com.flexerasoftware.fnocc.vo.AccountVO;
import com.flexerasoftware.fnocc.vo.AddressVO;
import com.flexerasoftware.fnocc.vo.EntitlementLineVO;
import com.flexerasoftware.fnocc.vo.EntitlementVO;
import com.flexerasoftware.fnocc.vo.UserVO;
import com.flexnet.operations.webservices.EntitlementDataType;
import com.flexnet.operations.webservices.EntitlementLineItemDataType;
import com.flexnet.operations.webservices.SimpleEntitlementDataType;

/**
 * @author Jawaid
 *
 */
public class AvangateService {

	private static final String COUNTRY_CODE = "COUNTRY_CODE";

	private static final String IPN_DATE = "IPN_DATE";

	private static final String IPN_PNAME = "IPN_PNAME[]";

	private static final String LICENSE_TYPE_RENEW = "RENEW";

	private static final String LICENSE_TYPE_REGULAR = "REGULAR";

	private static final String IPN_LICENSE_TYPE = "IPN_LICENSE_TYPE[]";

	private static final String IPN_QTY = "IPN_QTY[]";

	private static final String IPN_PID = "IPN_PID[]";

	private static final String IPN_LICENSE_REF = "IPN_LICENSE_REF[]";

	private static final String ZIPCODE = "ZIPCODE";

	private static final String CITY = "CITY";

	private static final String COMPANY_CODE = "COMPANY_CODE";

	private static final String ADDRESS2 = "ADDRESS2";

	private static final String ADDRESS1 = "ADDRESS1";

	private static final String NOT_US_OR_CANADA = "NOT US OR CANADA";

	private static final String LASTNAME = "LASTNAME";

	private static final String FIRSTNAME = "FIRSTNAME";

	private static final String CUSTOMEREMAIL = "CUSTOMEREMAIL";

	private static final String COMPANY = "COMPANY";

	private static final String MISSING_FIELDS_FOUND = "MISSING_FIELDS_FOUND";

    private static final String LICENSE_CODE = "LICENSE_CODE";

    private static final String EXPIRATION_DATE = "EXPIRATION_DATE";

    private static final String DATE = "DATE";

    public static final String ACTIVATION = "_ACTIVATION";


    static Logger log = Logger.getLogger(AvangateService.class.getName());
	
	private SecretKeyProperties secretKeyProperties;
	private MaterialiseProperties materialiseProperties;

	ApplicationContext secretKeyCTX = new AnnotationConfigApplicationContext(SecretKeyProperties.class);
	ApplicationContext materialiseCTX = new AnnotationConfigApplicationContext(MaterialiseProperties.class);

	

	/**
	 * Data taken in from the External system in a byte array format.
	 */
	private HttpServletRequest incomingData;
	private SimpleDateFormat dateFormat;
	private Date currentDate = new Date();

	private boolean validAvangateSource;


	public AvangateService(HttpServletRequest ipn) throws Exception {
		this.incomingData = ipn;
		dateFormat = new SimpleDateFormat("yyyyMMddHHmmss");
		
		//log.info(this.getTestSecretkey());
	}
	
	/**
	 * Validate the HMAC to determine if the source data is actually from Avangate
	 * 
	 * @return
	 */
	public boolean isValidAvangateSource(Map<String,String[]> data){
		//TODO: Implementation to be verified by avangate
		 //now calculate the length of each string and concatenate
		this.secretKeyProperties = secretKeyCTX.getBean(SecretKeyProperties.class);
		AvangateHmacmd md5 = AvangateHmacmd.getInstance();
    	StringBuffer sb = new StringBuffer();
    	String generatedHashCode="";
        String hashFromData ="";
        Set<String> keySet = data.keySet();
        for(String key: keySet) {
            if (!key.equals("HASH")) {
                int valLength = 0;
                String val = data.get(key)[0];
                if (val == null || val.isEmpty()) {
                    valLength = 0;
                    sb.append(String.format("%s", valLength));
                    System.out.println("Was null or Empty-" + valLength);
                } else if (val.equalsIgnoreCase("0")) {
                    valLength = 1;
                    sb.append(String.format("%s%s", valLength, val));
                    System.out.println(valLength + "-" + val);
                } else {
                    valLength = val.getBytes().length;
                    sb.append(String.format("%s%s", valLength, val));
                    System.out.println(valLength + "-" + val);
                }
            }else{
                hashFromData = data.get(key)[0];
            }
        }
    	
    		//String dataforhmac = "192016-06-01 12:22:097100003702138COMPLETE13Wire transfer4John5Smith9BV-66778800000015101 Main Street08New York8New York650036524United States of America12951-121-2121019johnsmith@email.com4John5Smith015101 Main Street08New York8New York650036524United States of America12951-121-212114213.233.121.503USD1116Software program5PM_11011529.0040.00040.0000529.00534.0045.0043.381420050303123434";
    		//System.out.println("The hash code is:"+md5.calculatehmac(dataforhmac, "AABBCCDDEEFF"));
    		try {
    			generatedHashCode = md5.calculatehmac(sb.toString().trim(), this.secretKeyProperties.getTestSecretkey());
    			System.out.println("The hash code is:"+generatedHashCode);
			} catch (InvalidKeyException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("Error ocurred invalid key",e);
				validAvangateSource = false;
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				log.error("No Such Algorithm Exception",e);
				validAvangateSource = false;
			}
        validAvangateSource = generatedHashCode.equals(hashFromData);
    	return generatedHashCode.equals(hashFromData);
	}
	
	public String acknowledgeReceipt() {
		if (validAvangateSource)
		{
            this.secretKeyProperties = secretKeyCTX.getBean(SecretKeyProperties.class);

            //now calculate the length of each string and concatenate
			String hmacStr = "NOT_GENERATED";
			Map<String, String[]> avangateData = incomingData.getParameterMap();

			StringBuffer sb = new StringBuffer();
	    	sb.append(String.format("%s%s", avangateData.get(IPN_PID)[0].getBytes().length, avangateData.get(IPN_PID)[0]  ));
	    	sb.append(String.format("%s%s", avangateData.get(IPN_PNAME)[0].getBytes().length, avangateData.get(IPN_PNAME)[0]  ));
	    	//IPN date in the YmdHis format (ex: 20081117145935)
	    	sb.append(String.format("%s%s", avangateData.get(IPN_DATE)[0].getBytes().length, avangateData.get(IPN_DATE)[0]  ));
	    	//Response issuing date (server time) in the YmdHis format (ex: 20081117145935)	
	    	String dtToStr = dateFormat.format(currentDate);

	    	sb.append(String.format("%s%s", dtToStr.getBytes().length, dtToStr  ));


	    	AvangateHmacmd md5 = AvangateHmacmd.getInstance();
			
			try {
				//TODO:READ THE KEY FROM THE PROPERTIES FILE
                hmacStr = String.format("<EPAYMENT>%s|%s</EPAYMENT>", dtToStr, md5.calculatehmac(sb.toString().trim(), this.secretKeyProperties.getTestSecretkey()));
                log.info("HMAC: "+hmacStr);
                log.info("SOURCE: "+ sb.toString().trim());
			} catch (InvalidKeyException | NoSuchAlgorithmException e) {
				log.error("Error has occurred.", e);
			}
			return hmacStr;
		}else{		
			return ("Data received did not pass validation test.");
		}
	}

    public String acknowledgeReceiptLCN() {

        if (validAvangateSource)
        {
            //now calculate the length of each string and concatenate
            String hmacStr = "NOT_GENERATED";
            Map<String, String[]> avangateData = incomingData.getParameterMap();

            StringBuffer sb = new StringBuffer();
            sb.append(String.format("%s%s", avangateData.get(LICENSE_CODE)[0].getBytes().length, avangateData.get(LICENSE_CODE)[0]  ));
            sb.append(String.format("%s%s", avangateData.get(EXPIRATION_DATE)[0].getBytes().length, avangateData.get(EXPIRATION_DATE)[0]  ));
            //IPN date in the YmdHis format (ex: 20081117145935)
     //       sb.append(String.format("%s%s", avangateData.get(DATE)[0].getBytes(), avangateData.get(DATE)[0]  ));
            //Response issuing date (server time) in the YmdHis format (ex: 20081117145935)
            String dtToStr = dateFormat.format(currentDate);
            sb.append(String.format("%s%s", dtToStr.getBytes().length, dtToStr  ));

            AvangateHmacmd md5 = AvangateHmacmd.getInstance();

            try {
                //TODO:READ THE KEY FROM THE PROPERTIES FILE
                hmacStr = String.format("<EPAYMENT>%s|%s</EPAYMENT>", dtToStr, md5.calculatehmac(sb.toString().trim(), this.secretKeyProperties.getTestSecretkey()));
            } catch (InvalidKeyException | NoSuchAlgorithmException e) {
                log.error("Error has occurred.", e);
            }
            return hmacStr;
        }else{
            return ("Data received did not pass validation test.");
        }
    }

    public String acknowledgeReceiptEDR() {

        if (validAvangateSource)
        {
            //now calculate the length of each string and concatenate
            String hmacStr = "NOT_GENERATED";
            String activationCode ="";
            String clsID = "";

                //TODO:GET INFO FOR EDR RECEIPT
                hmacStr = String.format("<CODE>%s</CODE><CODE>%s</CODE>", activationCode, clsID);
            return hmacStr;
        }else{
            return ("Data received did not pass validation test.");
        }
    }

	

	/**
	 * Operates to take the incoming data and translate that to the common
	 * data model.
	 * 
	 * @see com.flexerasoftware.fnocc.service.ExternalService#process()
	 */
	public void process() throws Exception {
		if (incomingData == null) {
			throw new Exception("No data set.");
		}

		try {
			
			//map data
			//NOTE: HAD TO ENABLE COUNTRY_CODE, IPN_LICENSE_REF, IPN_LICENSE_TYPE, IPN_LICENSE_EXP[] in Avangate system
			

			// TODO: PROCESS THE INCOMING DATA
			
			Map<String, String[]> avangateData = incomingData.getParameterMap();
			
			//validate mandatory fields
			avangateData = validateOrderData(avangateData);
			if (avangateData.containsKey(MISSING_FIELDS_FOUND)){
				throw new Exception(String.format("Missing data in the request %s", avangateData.get(MISSING_FIELDS_FOUND)[0]));
			}
						
			String s = incomingData.getParameter(IPN_PID);
			
			String ipnLicenseType = avangateData.get(IPN_LICENSE_TYPE)[0];
			
			if (ipnLicenseType.equalsIgnoreCase(LICENSE_TYPE_REGULAR)){
				
			}else if (ipnLicenseType.equals(LICENSE_TYPE_RENEW)) {
				
			}else{
				throw new Exception("Only REGULAR and RENEW IPN license types expected, Transaction aborted");
			}

			AccountVO account = new AccountVO();
			account.setId(avangateData.get(COMPANY)[0]);
			account.setName(avangateData.get(COMPANY)[0]);
			UserVO[] users = new UserVO[1];
			UserVO user = new UserVO();
			user.setAccountID(account.getId());
			user.setEmail(avangateData.get(CUSTOMEREMAIL)[0]);
			user.setFirstName(avangateData.get(FIRSTNAME)[0]);
			user.setLastName(avangateData.get(LASTNAME)[0]);
			AddressVO address = new AddressVO();
			address.setAddress1(avangateData.get(ADDRESS1)[0]);
			address.setAddress2(avangateData.get(ADDRESS2)[0]);
			address.setCountry(avangateData.get(COUNTRY_CODE)[0]);

			address.setCity(avangateData.get(CITY)[0]);
			address.setState(NOT_US_OR_CANADA);
			address.setZipcode(avangateData.get(ZIPCODE)[0]);
			user.setAddress(address);
			users[0] = user;
			account.setUsers(users);
			EntitlementVO entitlement = new EntitlementVO();
			entitlement.setAccount(account);
			entitlement.setId(avangateData.get(IPN_LICENSE_REF)[0]);
			entitlement.setOrderDate(new Date());
			EntitlementLineVO line = new EntitlementLineVO();
			line.setLineNumber(1);
			line.setSKU(avangateData.get(IPN_PID)[0]);
			line.setEffectiveDate(new Date());
			line.setQuantity(Integer.parseInt(avangateData.get(IPN_QTY)[0]));
			EntitlementLineVO[] lines = new EntitlementLineVO[1];
			lines[0] = line;
			entitlement.setLines(lines);		
			
			//process the order			
			processAvangateOrder(entitlement);		
			
			

		} catch (Exception e) {
			log.error("Error has occurred.", e);
		}
	}
	
	private Map<String, String[]> validateOrderData(Map<String, String[]> avangateData){
		
		StringBuffer missingFields = new StringBuffer();

		//Account
		if (null == avangateData.get(COMPANY)[0] || "".equalsIgnoreCase(avangateData.get(COMPANY)[0])){
        	missingFields.append(String.format("%s%s", " ", avangateData.get(COMPANY)[0]));
        }
		//USER
		if (null == avangateData.get(CUSTOMEREMAIL)[0] || "".equalsIgnoreCase(avangateData.get(CUSTOMEREMAIL)[0])){
        	missingFields.append(String.format("%s%s", " ", avangateData.get(CUSTOMEREMAIL)[0]));
		}
	   	 if (null == avangateData.get(FIRSTNAME)[0] || "".equalsIgnoreCase(avangateData.get(FIRSTNAME)[0])){
	           	missingFields.append(String.format("%s%s", " ", avangateData.get(FIRSTNAME)[0]));
	         }
	   	 if (null == avangateData.get(LASTNAME)[0] || "".equalsIgnoreCase(avangateData.get(LASTNAME)[0])){
	           	missingFields.append(String.format("%s%s", " ", avangateData.get(LASTNAME)[0]));
	         }
	   	 if (null == avangateData.get(ADDRESS1)[0] || "".equalsIgnoreCase(avangateData.get(ADDRESS1)[0])){
	           	missingFields.append(String.format("%s%s", " ", avangateData.get(ADDRESS1)[0]));
	         }
	   	 if (null == avangateData.get(ZIPCODE)[0] || "".equalsIgnoreCase(avangateData.get(ZIPCODE)[0])){
	           	missingFields.append(String.format("%s%s", " ", avangateData.get(ZIPCODE)[0]));
	         }
	   	 if (null == avangateData.get(COUNTRY_CODE)[0] || "".equalsIgnoreCase(avangateData.get(COUNTRY_CODE)[0])){
	           	missingFields.append(String.format("%s%s", " ", avangateData.get(COUNTRY_CODE)[0]));
	         }
	   	 //Acknowledgement data
	   	 if (null == avangateData.get(IPN_PID)[0] || "".equalsIgnoreCase(avangateData.get(IPN_PID)[0])){
	           	missingFields.append(String.format("%s%s", " ", avangateData.get(IPN_PID)[0]));
	         }
	   	 if (null == avangateData.get(IPN_PNAME)[0] || "".equalsIgnoreCase(avangateData.get(IPN_PNAME)[0])){
	           	missingFields.append(String.format("%s%s", " ", avangateData.get(IPN_PNAME)[0]));
	         }
	   	 if (null == avangateData.get(IPN_DATE)[0] || "".equalsIgnoreCase(avangateData.get(IPN_DATE)[0])){
	           	missingFields.append(String.format("%s%s", " ", avangateData.get(IPN_DATE)[0]));
	         }
       	 

		if (missingFields.length() > 0){
			avangateData.put(MISSING_FIELDS_FOUND, new String[]{missingFields.toString()});
		}
		return avangateData;
		
	}


    public void processAvangateOrder(EntitlementVO entitlement){

        try{
            ALMIntegrationService almSvc = new ALMIntegrationService();

            //does entitlement exist, create/update
            EntitlementDataType[] entData = almSvc.getEntitlement(entitlement);
            if (null == entData){
                //does account exist?
                AccountVO acctVO = almSvc.getAccount(entitlement.getAccount());
                //rule in Avangate, one company = one user, however one user can be linked to multiple companies
                //therefore below not expecting multiple users to be returned, in any get the first one
                UserVO	userVOAvangate = almSvc.getUser(entitlement.getAccount().getUsers()[0]);

                //check if this user exist in the FNO Cloud
                //UserVO userVOFNO = almSvc.getUserWithLinkedOrgs(userVOAvangate);

                if (null == acctVO.getAddress()){
                    //create account
                    almSvc.addAccount(entitlement.getAccount());
                    //if user exist in other organisation in FNO try to link to the new org now
                    if (userVOAvangate.getOrgsLinked().size() > 0 && !userVOAvangate.getOrgsLinked().contains(entitlement.getAccount().getName())){
                        //link new organisation
                        almSvc.linkUserToOrganisation(userVOAvangate, entitlement.getAccount().getName());
                    }
                }

                //now add entitlement, Line 1 is usage based part number as received from the Avangate
                //and add another Line 2 as the activation based line
                addActivationEntitlementline(entitlement);

                almSvc.addEntitlement(entitlement);
            }
            //get the entitlement lines for this order, expecting two
            //1. Usage based
            //2. Activation based

            SimpleEntitlementDataType simpleEntDataType = entData[0].getSimpleEntitlement();
            //expected one entitlement one line item 1:1
            //if (simpleEntDataType.getLineItems().length >1 ){
            //	log.warn(String.format("Unexpectedly, more than a single entitlement line found in entitlement id %s",
            //			simpleEntDataType.getEntitlementId().getId()));
            //	}

            EntitlementLineItemDataType entLine = simpleEntDataType.getLineItems(0);
            entLine.setExpirationDate(entitlement.getLines()[0].getExpirationDate());
            simpleEntDataType.setLineItems(new EntitlementLineItemDataType[]  {entLine});
            entData[0].setSimpleEntitlement(simpleEntDataType);



            //almSvc.updateEntitlement(entitlement);





        }catch (Exception ex){
            log.error("Error occurred processing Order", ex);
        }
    }


    void addActivationEntitlementline(EntitlementVO entitlementVO){
        //Avangate will only send a single entitlement line per entitlement
        EntitlementLineVO lineForUsageProduct = entitlementVO.getLines()[0];
        EntitlementLineVO lineForActivationProduct = new EntitlementLineVO();

        lineForActivationProduct.setLineNumber(lineForUsageProduct.getLineNumber()+1);
        lineForActivationProduct.setSKU(String.format("%s%s", lineForUsageProduct.getSKU(), ACTIVATION));
        lineForActivationProduct.setEffectiveDate(new Date());
        lineForActivationProduct.setQuantity(lineForUsageProduct.getQuantity());
        EntitlementLineVO[] lines = new EntitlementLineVO[1];
        lines[0] = lineForActivationProduct;

    }

}
