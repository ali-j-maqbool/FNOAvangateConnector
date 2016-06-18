/**
 * SearchEntitlementLineItemPropertiesRequestType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.flexnet.operations.webservices;

public class SearchEntitlementLineItemPropertiesRequestType  implements java.io.Serializable {
    private com.flexnet.operations.webservices.SearchActivatableItemDataType queryParams;

    private com.flexnet.operations.webservices.EntitlementLineItemResponseConfigRequestType entitlementLineItemResponseConfig;

    private java.math.BigInteger batchSize;

    private java.math.BigInteger pageNumber;

    public SearchEntitlementLineItemPropertiesRequestType() {
    }

    public SearchEntitlementLineItemPropertiesRequestType(
           com.flexnet.operations.webservices.SearchActivatableItemDataType queryParams,
           com.flexnet.operations.webservices.EntitlementLineItemResponseConfigRequestType entitlementLineItemResponseConfig,
           java.math.BigInteger batchSize,
           java.math.BigInteger pageNumber) {
           this.queryParams = queryParams;
           this.entitlementLineItemResponseConfig = entitlementLineItemResponseConfig;
           this.batchSize = batchSize;
           this.pageNumber = pageNumber;
    }


    /**
     * Gets the queryParams value for this SearchEntitlementLineItemPropertiesRequestType.
     * 
     * @return queryParams
     */
    public com.flexnet.operations.webservices.SearchActivatableItemDataType getQueryParams() {
        return queryParams;
    }


    /**
     * Sets the queryParams value for this SearchEntitlementLineItemPropertiesRequestType.
     * 
     * @param queryParams
     */
    public void setQueryParams(com.flexnet.operations.webservices.SearchActivatableItemDataType queryParams) {
        this.queryParams = queryParams;
    }


    /**
     * Gets the entitlementLineItemResponseConfig value for this SearchEntitlementLineItemPropertiesRequestType.
     * 
     * @return entitlementLineItemResponseConfig
     */
    public com.flexnet.operations.webservices.EntitlementLineItemResponseConfigRequestType getEntitlementLineItemResponseConfig() {
        return entitlementLineItemResponseConfig;
    }


    /**
     * Sets the entitlementLineItemResponseConfig value for this SearchEntitlementLineItemPropertiesRequestType.
     * 
     * @param entitlementLineItemResponseConfig
     */
    public void setEntitlementLineItemResponseConfig(com.flexnet.operations.webservices.EntitlementLineItemResponseConfigRequestType entitlementLineItemResponseConfig) {
        this.entitlementLineItemResponseConfig = entitlementLineItemResponseConfig;
    }


    /**
     * Gets the batchSize value for this SearchEntitlementLineItemPropertiesRequestType.
     * 
     * @return batchSize
     */
    public java.math.BigInteger getBatchSize() {
        return batchSize;
    }


    /**
     * Sets the batchSize value for this SearchEntitlementLineItemPropertiesRequestType.
     * 
     * @param batchSize
     */
    public void setBatchSize(java.math.BigInteger batchSize) {
        this.batchSize = batchSize;
    }


    /**
     * Gets the pageNumber value for this SearchEntitlementLineItemPropertiesRequestType.
     * 
     * @return pageNumber
     */
    public java.math.BigInteger getPageNumber() {
        return pageNumber;
    }


    /**
     * Sets the pageNumber value for this SearchEntitlementLineItemPropertiesRequestType.
     * 
     * @param pageNumber
     */
    public void setPageNumber(java.math.BigInteger pageNumber) {
        this.pageNumber = pageNumber;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof SearchEntitlementLineItemPropertiesRequestType)) return false;
        SearchEntitlementLineItemPropertiesRequestType other = (SearchEntitlementLineItemPropertiesRequestType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.queryParams==null && other.getQueryParams()==null) || 
             (this.queryParams!=null &&
              this.queryParams.equals(other.getQueryParams()))) &&
            ((this.entitlementLineItemResponseConfig==null && other.getEntitlementLineItemResponseConfig()==null) || 
             (this.entitlementLineItemResponseConfig!=null &&
              this.entitlementLineItemResponseConfig.equals(other.getEntitlementLineItemResponseConfig()))) &&
            ((this.batchSize==null && other.getBatchSize()==null) || 
             (this.batchSize!=null &&
              this.batchSize.equals(other.getBatchSize()))) &&
            ((this.pageNumber==null && other.getPageNumber()==null) || 
             (this.pageNumber!=null &&
              this.pageNumber.equals(other.getPageNumber())));
        __equalsCalc = null;
        return _equals;
    }

    private boolean __hashCodeCalc = false;
    public synchronized int hashCode() {
        if (__hashCodeCalc) {
            return 0;
        }
        __hashCodeCalc = true;
        int _hashCode = 1;
        if (getQueryParams() != null) {
            _hashCode += getQueryParams().hashCode();
        }
        if (getEntitlementLineItemResponseConfig() != null) {
            _hashCode += getEntitlementLineItemResponseConfig().hashCode();
        }
        if (getBatchSize() != null) {
            _hashCode += getBatchSize().hashCode();
        }
        if (getPageNumber() != null) {
            _hashCode += getPageNumber().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(SearchEntitlementLineItemPropertiesRequestType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:com.macrovision:flexnet/operations", "searchEntitlementLineItemPropertiesRequestType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("queryParams");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:com.macrovision:flexnet/operations", "queryParams"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:com.macrovision:flexnet/operations", "searchActivatableItemDataType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("entitlementLineItemResponseConfig");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:com.macrovision:flexnet/operations", "entitlementLineItemResponseConfig"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:com.macrovision:flexnet/operations", "entitlementLineItemResponseConfigRequestType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("batchSize");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:com.macrovision:flexnet/operations", "batchSize"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("pageNumber");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:com.macrovision:flexnet/operations", "pageNumber"));
        elemField.setXmlType(new javax.xml.namespace.QName("http://www.w3.org/2001/XMLSchema", "integer"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
    }

    /**
     * Return type metadata object
     */
    public static org.apache.axis.description.TypeDesc getTypeDesc() {
        return typeDesc;
    }

    /**
     * Get Custom Serializer
     */
    public static org.apache.axis.encoding.Serializer getSerializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanSerializer(
            _javaType, _xmlType, typeDesc);
    }

    /**
     * Get Custom Deserializer
     */
    public static org.apache.axis.encoding.Deserializer getDeserializer(
           java.lang.String mechType, 
           java.lang.Class _javaType,  
           javax.xml.namespace.QName _xmlType) {
        return 
          new  org.apache.axis.encoding.ser.BeanDeserializer(
            _javaType, _xmlType, typeDesc);
    }

}