package com.educacionit.servicios;

public class UsuarioServicioProxy implements com.educacionit.servicios.UsuarioServicio {
  private String _endpoint = null;
  private com.educacionit.servicios.UsuarioServicio usuarioServicio = null;
  
  public UsuarioServicioProxy() {
    _initUsuarioServicioProxy();
  }
  
  public UsuarioServicioProxy(String endpoint) {
    _endpoint = endpoint;
    _initUsuarioServicioProxy();
  }
  
  private void _initUsuarioServicioProxy() {
    try {
      usuarioServicio = (new com.educacionit.servicios.UsuarioServicioServiceLocator()).getUsuarioServicio();
      if (usuarioServicio != null) {
        if (_endpoint != null)
          ((javax.xml.rpc.Stub)usuarioServicio)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
        else
          _endpoint = (String)((javax.xml.rpc.Stub)usuarioServicio)._getProperty("javax.xml.rpc.service.endpoint.address");
      }
      
    }
    catch (javax.xml.rpc.ServiceException serviceException) {}
  }
  
  public String getEndpoint() {
    return _endpoint;
  }
  
  public void setEndpoint(String endpoint) {
    _endpoint = endpoint;
    if (usuarioServicio != null)
      ((javax.xml.rpc.Stub)usuarioServicio)._setProperty("javax.xml.rpc.service.endpoint.address", _endpoint);
    
  }
  
  public com.educacionit.servicios.UsuarioServicio getUsuarioServicio() {
    if (usuarioServicio == null)
      _initUsuarioServicioProxy();
    return usuarioServicio;
  }
  
  public com.educacionit.dtos.UsuarioDTO buscarEntidad(java.lang.String correo) throws java.rmi.RemoteException{
    if (usuarioServicio == null)
      _initUsuarioServicioProxy();
    return usuarioServicio.buscarEntidad(correo);
  }
  
  public com.educacionit.dtos.UsuarioDTO modificarEntidad(com.educacionit.dtos.UsuarioDTO usuarioDTO) throws java.rmi.RemoteException{
    if (usuarioServicio == null)
      _initUsuarioServicioProxy();
    return usuarioServicio.modificarEntidad(usuarioDTO);
  }
  
  public com.educacionit.dtos.UsuarioDTO insertarEntidad(com.educacionit.dtos.UsuarioDTO usuarioDTO) throws java.rmi.RemoteException{
    if (usuarioServicio == null)
      _initUsuarioServicioProxy();
    return usuarioServicio.insertarEntidad(usuarioDTO);
  }
  
  public boolean eliminarEntidad(com.educacionit.dtos.UsuarioDTO usuarioDTO) throws java.rmi.RemoteException{
    if (usuarioServicio == null)
      _initUsuarioServicioProxy();
    return usuarioServicio.eliminarEntidad(usuarioDTO);
  }
  
  public com.educacionit.dtos.UsuarioDTO[] listarEntidad() throws java.rmi.RemoteException{
    if (usuarioServicio == null)
      _initUsuarioServicioProxy();
    return usuarioServicio.listarEntidad();
  }
  
  
}