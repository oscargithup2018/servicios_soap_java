package server;

public class ServicioSoapTransportePortTypeProxy implements server.ServicioSoapTransportePortType {
  private String _endpoint = null;
  private server.ServicioSoapTransportePortType servicioSoapTransportePortType = null;
  
  public ServicioSoapTransportePortTypeProxy() {
    _initServicioSoapTransportePortTypeProxy();
  }
  
  public ServicioSoapTransportePortTypeProxy(String endpoint) {
    _endpoint = endpoint;
    _initServicioSoapTransportePortTypeProxy();
  }
  
  private void _initServicioSoapTransportePortTypeProxy() {
    try {
      servicioSoapTransportePortType = (new server.ServicioSoapTransporteLocator()).getservicioSoapTransportePort();
      if (servicioSoapTransportePortType != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)servicioSoapTransportePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)servicioSoapTransportePortType)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (servicioSoapTransportePortType != null)
      ((javax.xml.rpc.Stub)servicioSoapTransportePortType)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public server.ServicioSoapTransportePortType getServicioSoapTransportePortType() {
    if (servicioSoapTransportePortType == null)
      _initServicioSoapTransportePortTypeProxy();
    return servicioSoapTransportePortType;
  }
  
  public java.lang.String createPerson(java.lang.String name, java.lang.String apellido, java.lang.String identificacion, java.lang.String idEmpresa, java.lang.String idRol) throws java.rmi.RemoteException{
    if (servicioSoapTransportePortType == null)
      _initServicioSoapTransportePortTypeProxy();
    return servicioSoapTransportePortType.createPerson(name, apellido, identificacion, idEmpresa, idRol);
  }
  
  public java.lang.String findPerson(java.lang.String idPersona) throws java.rmi.RemoteException{
    if (servicioSoapTransportePortType == null)
      _initServicioSoapTransportePortTypeProxy();
    return servicioSoapTransportePortType.findPerson(idPersona);
  }
  
  public java.lang.String fetchAllPersons(java.lang.String all) throws java.rmi.RemoteException{
    if (servicioSoapTransportePortType == null)
      _initServicioSoapTransportePortTypeProxy();
    return servicioSoapTransportePortType.fetchAllPersons(all);
  }
  
  
}