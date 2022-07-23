/**
 * UsuarioServicio.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package com.educacionit.servicios;

public interface UsuarioServicio extends java.rmi.Remote {
    public com.educacionit.dtos.UsuarioDTO buscarEntidad(java.lang.String correo) throws java.rmi.RemoteException;
    public com.educacionit.dtos.UsuarioDTO modificarEntidad(com.educacionit.dtos.UsuarioDTO usuarioDTO) throws java.rmi.RemoteException;
    public com.educacionit.dtos.UsuarioDTO insertarEntidad(com.educacionit.dtos.UsuarioDTO usuarioDTO) throws java.rmi.RemoteException;
    public boolean eliminarEntidad(com.educacionit.dtos.UsuarioDTO usuarioDTO) throws java.rmi.RemoteException;
    public com.educacionit.dtos.UsuarioDTO[] listarEntidad() throws java.rmi.RemoteException;
}
