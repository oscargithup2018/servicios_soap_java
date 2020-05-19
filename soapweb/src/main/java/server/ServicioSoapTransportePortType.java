/**
 * ServicioSoapTransportePortType.java
 *
 * This file was auto-generated from WSDL
 * by the Apache Axis 1.4 Apr 22, 2006 (06:55:48 PDT) WSDL2Java emitter.
 */

package server;

public interface ServicioSoapTransportePortType extends java.rmi.Remote {

    /**
     * Crear una nueva persona
     */
    public java.lang.String createPerson(java.lang.String name, java.lang.String apellido, java.lang.String identificacion, java.lang.String idEmpresa, java.lang.String idRol) throws java.rmi.RemoteException;

    /**
     * Traer un registro de la tabla persona
     */
    public java.lang.String findPerson(java.lang.String idPersona) throws java.rmi.RemoteException;

    /**
     * Traer todas las personas
     */
    public java.lang.String fetchAllPersons(java.lang.String all) throws java.rmi.RemoteException;
}
