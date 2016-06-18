/**
 * GeneratePrebuiltLicenseDataListType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.flexnet.opsembedded.webservices;

public class GeneratePrebuiltLicenseDataListType  implements java.io.Serializable {
    private com.flexnet.opsembedded.webservices.DeviceIdentifier[] deviceIdentifier;

    public GeneratePrebuiltLicenseDataListType() {
    }

    public GeneratePrebuiltLicenseDataListType(
           com.flexnet.opsembedded.webservices.DeviceIdentifier[] deviceIdentifier) {
           this.deviceIdentifier = deviceIdentifier;
    }


    /**
     * Gets the deviceIdentifier value for this GeneratePrebuiltLicenseDataListType.
     * 
     * @return deviceIdentifier
     */
    public com.flexnet.opsembedded.webservices.DeviceIdentifier[] getDeviceIdentifier() {
        return deviceIdentifier;
    }


    /**
     * Sets the deviceIdentifier value for this GeneratePrebuiltLicenseDataListType.
     * 
     * @param deviceIdentifier
     */
    public void setDeviceIdentifier(com.flexnet.opsembedded.webservices.DeviceIdentifier[] deviceIdentifier) {
        this.deviceIdentifier = deviceIdentifier;
    }

    public com.flexnet.opsembedded.webservices.DeviceIdentifier getDeviceIdentifier(int i) {
        return this.deviceIdentifier[i];
    }

    public void setDeviceIdentifier(int i, com.flexnet.opsembedded.webservices.DeviceIdentifier _value) {
        this.deviceIdentifier[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof GeneratePrebuiltLicenseDataListType)) return false;
        GeneratePrebuiltLicenseDataListType other = (GeneratePrebuiltLicenseDataListType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.deviceIdentifier==null && other.getDeviceIdentifier()==null) || 
             (this.deviceIdentifier!=null &&
              java.util.Arrays.equals(this.deviceIdentifier, other.getDeviceIdentifier())));
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
        if (getDeviceIdentifier() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getDeviceIdentifier());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getDeviceIdentifier(), i);
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
        new org.apache.axis.description.TypeDesc(GeneratePrebuiltLicenseDataListType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:com.macrovision:flexnet/opsembedded", "generatePrebuiltLicenseDataListType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("deviceIdentifier");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:com.macrovision:flexnet/opsembedded", "deviceIdentifier"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:com.macrovision:flexnet/opsembedded", "deviceIdentifier"));
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
