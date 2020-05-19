/**
 * ServicioSoapTransporteLocator.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package server;

public class ServicioSoapTransporteLocator extends org.apache.axis.client.Service implements server.ServicioSoapTransporte {

    public ServicioSoapTransporteLocator() {
    }


    public ServicioSoapTransporteLocator(org.apache.axis.EngineConfiguration config) {
        super(config);
    }

    public ServicioSoapTransporteLocator(java.lang.String wsdlLoc, javax.xml.namespace.QName sName) throws javax.xml.rpc.ServiceException {
        super(wsdlLoc, sName);
    }

    // Use to get a proxy class for servicioSoapTransportePort
    private java.lang.String servicioSoapTransportePort_address = "http://localhost:8086/transporte/service.php";

    public java.lang.String getservicioSoapTransportePortAddress() {
        return servicioSoapTransportePort_address;
    }

    // The WSDD service name defaults to the port name.
    private java.lang.String servicioSoapTransportePortWSDDServiceName = "servicioSoapTransportePort";

    public java.lang.String getservicioSoapTransportePortWSDDServiceName() {
        return servicioSoapTransportePortWSDDServiceName;
    }

    public void setservicioSoapTransportePortWSDDServiceName(java.lang.String name) {
        servicioSoapTransportePortWSDDServiceName = name;
    }

    public server.ServicioSoapTransportePortType getservicioSoapTransportePort() throws javax.xml.rpc.ServiceException {
       java.net.URL endpoint;
        try {
            endpoint = new java.net.URL(servicioSoapTransportePort_address);
        }
        catch (java.net.MalformedURLException e) {
            throw new javax.xml.rpc.ServiceException(e);
        }
        return getservicioSoapTransportePort(endpoint);
    }

    public server.ServicioSoapTransportePortType getservicioSoapTransportePort(java.net.URL portAddress) throws javax.xml.rpc.ServiceException {
        try {
            server.ServicioSoapTransporteBindingStub _stub = new server.ServicioSoapTransporteBindingStub(portAddress, this);
            _stub.setPortName(getservicioSoapTransportePortWSDDServiceName());
            return _stub;
        }
        catch (org.apache.axis.AxisFault e) {
            return null;
        }
    }

    public void setservicioSoapTransportePortEndpointAddress(java.lang.String address) {
        servicioSoapTransportePort_address = address;
    }

    /**
     * For the given interface, get the stub implementation.
     * If this service has no port for the given interface,
     * then ServiceException is thrown.
     */
    public java.rmi.Remote getPort(Class serviceEndpointInterface) throws javax.xml.rpc.ServiceException {
        try {
            if (server.ServicioSoapTransportePortType.class.isAssignableFrom(serviceEndpointInterface)) {
                server.ServicioSoapTransporteBindingStub _stub = new server.ServicioSoapTransporteBindingStub(new java.net.URL(servicioSoapTransportePort_address), this);
                _stub.setPortName(getservicioSoapTransportePortWSDDServiceName());
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
        if ("servicioSoapTransportePort".equals(inputPortName)) {
            return getservicioSoapTransportePort();
        }
        else  {
            java.rmi.Remote _stub = getPort(serviceEndpointInterface);
            ((org.apache.axis.client.Stub) _stub).setPortName(portName);
            return _stub;
        }
    }

    public javax.xml.namespace.QName getServiceName() {
        return new javax.xml.namespace.QName("urn:server", "servicioSoapTransporte");
    }

    private java.util.HashSet ports = null;

    public java.util.Iterator getPorts() {
        if (ports == null) {
            ports = new java.util.HashSet();
            ports.add(new javax.xml.namespace.QName("urn:server", "servicioSoapTransportePort"));
        }
        return ports.iterator();
    }

    /**
    * Set the endpoint address for the specified port name.
    */
    public void setEndpointAddress(java.lang.String portName, java.lang.String address) throws javax.xml.rpc.ServiceException {
        
if ("servicioSoapTransportePort".equals(portName)) {
            setservicioSoapTransportePortEndpointAddress(address);
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
