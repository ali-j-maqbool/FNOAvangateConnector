/**
 * GetUsageSummaryResponseType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.flexnet.opsembedded.webservices;

public class GetUsageSummaryResponseType  implements java.io.Serializable {
    private com.flexnet.opsembedded.webservices.OpsEmbeddedStatusInfoType statusInfo;

    private com.flexnet.opsembedded.webservices.FailedGetUsageSummaryDataType failedData;

    private com.flexnet.opsembedded.webservices.GetUsageSummaryDataType responseData;

    public GetUsageSummaryResponseType() {
    }

    public GetUsageSummaryResponseType(
           com.flexnet.opsembedded.webservices.OpsEmbeddedStatusInfoType statusInfo,
           com.flexnet.opsembedded.webservices.FailedGetUsageSummaryDataType failedData,
           com.flexnet.opsembedded.webservices.GetUsageSummaryDataType responseData) {
           this.statusInfo = statusInfo;
           this.failedData = failedData;
           this.responseData = responseData;
    }


    /**
     * Gets the statusInfo value for this GetUsageSummaryResponseType.
     * 
     * @return statusInfo
     */
    public com.flexnet.opsembedded.webservices.OpsEmbeddedStatusInfoType getStatusInfo() {
        return statusInfo;
    }


    /**
     * Sets the statusInfo value for this GetUsageSummaryResponseType.
     * 
     * @param statusInfo
     */
    public void setStatusInfo(com.flexnet.opsembedded.webservices.OpsEmbeddedStatusInfoType statusInfo) {
        this.statusInfo = statusInfo;
    }


    /**
     * Gets the failedData value for this GetUsageSummaryResponseType.
     * 
     * @return failedData
     */
    public com.flexnet.opsembedded.webservices.FailedGetUsageSummaryDataType getFailedData() {
        return failedData;
    }


    /**
     * Sets the failedData value for this GetUsageSummaryResponseType.
     * 
     * @param failedData
     */
    public void setFailedData(com.flexnet.opsembedded.webservices.FailedGetUsageSummaryDataType failedData) {
        this.failedData = failedData;
    }


    /**
     * Gets the responseData value for this GetUsageSummaryResponseType.
     * 
     * @return responseData
     */
    public com.flexnet.opsembedded.webservices.GetUsageSummaryDataType getResponseData() {
        return responseData;
    }


    /**
     * Sets the responseData value for this GetUsageSummaryResponseType.
     * 
     * @param responseData
     */
    public void setResponseData(com.flexnet.opsembedded.webservices.GetUsageSummaryDataType responseData) {
        this.responseData = responseData;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GetUsageSummaryResponseType)) return false;
        GetUsageSummaryResponseType other = (GetUsageSummaryResponseType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.statusInfo==null && other.getStatusInfo()==null) || 
             (this.statusInfo!=null &&
              this.statusInfo.equals(other.getStatusInfo()))) &&
            ((this.failedData==null && other.getFailedData()==null) || 
             (this.failedData!=null &&
              this.failedData.equals(other.getFailedData()))) &&
            ((this.responseData==null && other.getResponseData()==null) || 
             (this.responseData!=null &&
              this.responseData.equals(other.getResponseData())));
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
        if (getStatusInfo() != null) {
            _hashCode += getStatusInfo().hashCode();
        }
        if (getFailedData() != null) {
            _hashCode += getFailedData().hashCode();
        }
        if (getResponseData() != null) {
            _hashCode += getResponseData().hashCode();
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(GetUsageSummaryResponseType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:com.macrovision:flexnet/opsembedded", "getUsageSummaryResponseType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("statusInfo");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:com.macrovision:flexnet/opsembedded", "statusInfo"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:com.macrovision:flexnet/opsembedded", "OpsEmbeddedStatusInfoType"));
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("failedData");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:com.macrovision:flexnet/opsembedded", "failedData"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:com.macrovision:flexnet/opsembedded", "failedGetUsageSummaryDataType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        typeDesc.addFieldDesc(elemField);
        elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("responseData");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:com.macrovision:flexnet/opsembedded", "responseData"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:com.macrovision:flexnet/opsembedded", "getUsageSummaryDataType"));
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
