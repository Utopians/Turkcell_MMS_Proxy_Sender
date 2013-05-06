/**
 * SubmitReqServiceLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.3 Oct 05, 2005 (05:23:37 EDT) WSDL2Java emitter.
 */

package com.turkcell.soapmmsproxy.mm7;

public class SubmitReqServiceLocator extends org.apache.axis.client.Service implements com.turkcell.soapmmsproxy.mm7.SubmitReqService {

/**
 * MMSProxy MM7 Service
 */

    public SubmitReqServiceLocator() {
    }


    public SubmitReqServiceLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public SubmitReqServiceLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for SubmitReqPort
    private java.lang.String SubmitReqPort_address = "http://localhost/MM7SubmitReq";

    public java.lang.String getSubmitReqPortAddress() {
        return SubmitReqPort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String SubmitReqPortWSDDServiceName = "SubmitReqPort";

    public java.lang.String getSubmitReqPortWSDDServiceName() {
        return SubmitReqPortWSDDServiceName;
    }

    public void setSubmitReqPortWSDDServiceName(java.lang.String name) {
        SubmitReqPortWSDDServiceName = name;
    }

    public com.turkcell.soapmmsproxy.mm7.SubmitReqPortType getSubmitReqPort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(SubmitReqPort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getSubmitReqPort(endpoint);
    }

    public com.turkcell.soapmmsproxy.mm7.SubmitReqPortType getSubmitReqPort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            com.turkcell.soapmmsproxy.mm7.SubmitReqBindingStub _stub = new com.turkcell.soapmmsproxy.mm7.SubmitReqBindingStub(portAddress, this);
            _stub.setPortName(getSubmitReqPortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setSubmitReqPortEndpointAddress(java.lang.String address) {
        SubmitReqPort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (com.turkcell.soapmmsproxy.mm7.SubmitReqPortType.class.isAssignableFrom(serviceEndpointInterface)) {
                com.turkcell.soapmmsproxy.mm7.SubmitReqBindingStub _stub = new com.turkcell.soapmmsproxy.mm7.SubmitReqBindingStub(new java.net.URL(SubmitReqPort_address), this);
                _stub.setPortName(getSubmitReqPortWSDDServiceName());
                return _stub;
            }
        }
        catch (java.lang.Throwable t) {
            throw new javax.xml.rpc.ServiceException(t);
        }
        throw new javax.xml.rpc.ServiceException("There is no stub implementation for the interface:  " + (serviceEndpointInterface == null ? "null" : serviceEndpointInterface.getName()));
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(javax.xml.namespace.QName portName, Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        if (portName == null) {
            return getPort(serviceEndpointInterface);
        }
        java.lang.String inputPortName = portName.getLocalPart();
        if ("SubmitReqPort".equals(inputPortName)) {
            return getSubmitReqPort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("http://www.turkcell.com.tr/webservices/MM7SubmitReq", "SubmitReqService");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("http://www.turkcell.com.tr/webservices/MM7SubmitReq", "SubmitReqPort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("SubmitReqPort".equals(portName)) {
            setSubmitReqPortEndpointAddress(address);
        }
        else 
{ // Unknown Port Name
            throw new javax.xml.rpc.ServiceException(" Cannot set Endpoint Address for Unknown Port" + portName);
        }
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(javax.xml.namespace.QName portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        setEndpointAddress(portName.getLocalPart(), address);
    }

}
