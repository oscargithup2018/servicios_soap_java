package co.com.soapweb.service.webservices;

import java.io.Serializable;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebMethod;
import javax.jws.WebParam;
import javax.jws.WebService;

import co.com.soapejb.modelo.Cliente;
import co.com.soapejb.services.ConsultorioServices;

@WebService(name = "producto")
@Stateless
public class ProductosServicesWeb implements Serializable {

	private static final long serialVersionUID = 1L;

	@EJB
	private ConsultorioServices consultorioServices;

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

}
