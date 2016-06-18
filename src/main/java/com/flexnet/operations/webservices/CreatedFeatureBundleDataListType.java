/**
 * CreatedFeatureBundleDataListType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.flexnet.operations.webservices;

public class CreatedFeatureBundleDataListType  implements java.io.Serializable {
    private com.flexnet.operations.webservices.CorrelationDataType[] createdFeatureBundle;

    public CreatedFeatureBundleDataListType() {
    }

    public CreatedFeatureBundleDataListType(
           com.flexnet.operations.webservices.CorrelationDataType[] createdFeatureBundle) {
           this.createdFeatureBundle = createdFeatureBundle;
    }


    /**
     * Gets the createdFeatureBundle value for this CreatedFeatureBundleDataListType.
     * 
     * @return createdFeatureBundle
     */
    public com.flexnet.operations.webservices.CorrelationDataType[] getCreatedFeatureBundle() {
        return createdFeatureBundle;
    }


    /**
     * Sets the createdFeatureBundle value for this CreatedFeatureBundleDataListType.
     * 
     * @param createdFeatureBundle
     */
    public void setCreatedFeatureBundle(com.flexnet.operations.webservices.CorrelationDataType[] createdFeatureBundle) {
        this.createdFeatureBundle = createdFeatureBundle;
    }

    public com.flexnet.operations.webservices.CorrelationDataType getCreatedFeatureBundle(int i) {
        return this.createdFeatureBundle[i];
    }

    public void setCreatedFeatureBundle(int i, com.flexnet.operations.webservices.CorrelationDataType _value) {
        this.createdFeatureBundle[i] = _value;
    }

    private java.lang.Object __equalsCalc = null;
    public synchronized boolean equals(java.lang.Object obj) {
        if (!(obj instanceof CreatedFeatureBundleDataListType)) return false;
        CreatedFeatureBundleDataListType other = (CreatedFeatureBundleDataListType) obj;
        if (obj == null) return false;
        if (this == obj) return true;
        if (__equalsCalc != null) {
            return (__equalsCalc == obj);
        }
        __equalsCalc = obj;
        boolean _equals;
        _equals = true && 
            ((this.createdFeatureBundle==null && other.getCreatedFeatureBundle()==null) || 
             (this.createdFeatureBundle!=null &&
              java.util.Arrays.equals(this.createdFeatureBundle, other.getCreatedFeatureBundle())));
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
        if (getCreatedFeatureBundle() != null) {
            for (int i=0;
                 i<java.lang.reflect.Array.getLength(getCreatedFeatureBundle());
                 i++) {
                java.lang.Object obj = java.lang.reflect.Array.get(getCreatedFeatureBundle(), i);
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
        new org.apache.axis.description.TypeDesc(CreatedFeatureBundleDataListType.class, true);

    static {
        typeDesc.setXmlType(new javax.xml.namespace.QName("urn:com.macrovision:flexnet/operations", "createdFeatureBundleDataListType"));
        org.apache.axis.description.ElementDesc elemField = new org.apache.axis.description.ElementDesc();
        elemField.setFieldName("createdFeatureBundle");
        elemField.setXmlName(new javax.xml.namespace.QName("urn:com.macrovision:flexnet/operations", "createdFeatureBundle"));
        elemField.setXmlType(new javax.xml.namespace.QName("urn:com.macrovision:flexnet/operations", "correlationDataType"));
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