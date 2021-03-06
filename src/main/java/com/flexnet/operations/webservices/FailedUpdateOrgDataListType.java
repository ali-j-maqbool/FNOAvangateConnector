/**
 * FailedUpdateOrgDataListType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.flexnet.operations.webservices;

public class FailedUpdateOrgDataListType  implements java.io.Serializable {
    private com.flexnet.operations.webservices.FailedUpdateOrgDataType[] failedOrg;

    public FailedUpdateOrgDataListType() {
    }

    public FailedUpdateOrgDataListType(
           com.flexnet.operations.webservices.FailedUpdateOrgDataType[] failedOrg) {
           this.failedOrg = failedOrg;
    }


    /**
     * Gets the failedOrg value for this FailedUpdateOrgDataListType.
     * 
     * @return failedOrg
     */
    public com.flexnet.operations.webservices.FailedUpdateOrgDataType[] getFailedOrg() {
        return failedOrg;
    }


    /**
     * Sets the failedOrg value for this FailedUpdateOrgDataListType.
     * 
     * @param failedOrg
     */
    public void setFailedOrg(com.flexnet.operations.webservices.FailedUpdateOrgDataType[] failedOrg) {
        this.failedOrg = failedOrg;
    }

    public com.flexnet.operations.webservices.FailedUpdateOrgDataType getFailedOrg(int i) {
        return this.failedOrg[i];
    }

    public void setFailedOrg(int i, com.flexnet.operations.webservices.FailedUpdateOrgDataType _value) {
        this.failedOrg[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof FailedUpdateOrgDataListType)) return false;
        FailedUpdateOrgDataListType other = (FailedUpdateOrgDataListType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.failedOrg==null && other.getFailedOrg()==null) || 
             (this.failedOrg!=null &&
              java.util.Arrays.equals(this.failedOrg, other.getFailedOrg())));
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
        if (getFailedOrg() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getFailedOrg());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getFailedOrg(), i);
                if (obj != null &&
                    !obj.getClass().isArray()) {
                    _hashCode += obj.hashCode();
                }
            }
        }
        __hashCodeCalc = false;
        return _hashCode;
    }

    // Type metadata
    private static org.apache.axis.description.TypeDesc typeDesc =
        new org.apache.axis.description.TypeDesc(FailedUpdateOrgDataListType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:com.macrovision:flexnet/operations", "failedUpdateOrgDataListType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("failedOrg");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:com.macrovision:flexnet/operations", "failedOrg"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:com.macrovision:flexnet/operations", "failedUpdateOrgDataType"));
        elemField.setMinOccurs(0);
        elemField.setNillable(false);
        elemField.setMaxOccursUnbounded(true);
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
