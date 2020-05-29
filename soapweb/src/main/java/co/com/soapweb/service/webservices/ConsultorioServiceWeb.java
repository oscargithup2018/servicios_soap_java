package co.com.soapweb.service.webservices;

import co.com.soapejb.modelo.Abogado;
import co.com.soapejb.modelo.Cliente;
import co.com.soapejb.services.ConsultorioServices;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@WebService(name = "consultorio")
@Stateless
public class ConsultorioServiceWeb implements Serializable {

    private static final long serialVersionUID = 1L;

    @EJB
    private ConsultorioServices consultorioServices;

    @WebMethod(operationName = "listPersons")
    public List<Cliente> listPersons() {
        List<Cliente> clienteArrayList = new ArrayList<>();
        try {
            clienteArrayList = consultorioServices.listClient();
        } catch (Exception e) {
            clienteArrayList = new ArrayList<>();
        }
        return clienteArrayList;
    }


    @WebMethod(operationName = "searchPerson")
    public Cliente searchClientByDocument(@WebParam(name = "documentPerson") String documentPerson) {
        Cliente clienteRetorno = new Cliente();
        try {
            if (documentPerson != null && !documentPerson.equals("")) {
                clienteRetorno = consultorioServices.searchByDocument(documentPerson);
            } else {
                clienteRetorno = new Cliente();
            }
        } catch (Exception e) {
            clienteRetorno = new Cliente();
        }
        return clienteRetorno;
    }

    @WebMethod(operationName = "createLawyer")
//    public boolean createLawyer(@WebParam(name = "abogado") Abogado lawyer) {
    public boolean createLawyer(@WebParam(name = "apellidos") String apellidos,
                                @WebParam(name = "direccion") String direccion, @WebParam(name = "email") String email,
                                @WebParam(name = "nombres") String nombres, @WebParam(name = "tarjeta") int tarjeta,
                                @WebParam(name = "telefono") String telefono) {
        boolean flag = false;
        Abogado lawyer = new Abogado(apellidos, direccion, email, nombres, tarjeta, telefono);
        try {
            if (lawyer.getNombres() != null && !lawyer.getNombres().equals("")) {
                flag = consultorioServices.createLawyer(lawyer);
            }
        } catch (Exception e) {
            Abogado abogado = new Abogado();
        }
        return flag;
    }

    @WebMethod(operationName = "deleteClient")
    public boolean deleteClient(@WebParam(name = "document") int document) {
        boolean flag = false;

        try {
            if (document > 0) {
                consultorioServices.deleteClient(document);
                flag = true;
            }
        } catch (Exception exception) {
            System.out.println(exception);
        }
        return flag;
    }

}
