package co.com.soapejb.services;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.ejb.TransactionManagementType;

import co.com.soapejb.fachada.ConsultorioFacade;
import co.com.soapejb.modelo.Abogado;
import co.com.soapejb.modelo.Cliente;
import co.com.soapejb.modelo.Juzgado;

@Stateless
@LocalBean
@TransactionAttribute(TransactionAttributeType.NOT_SUPPORTED)
public class ConsultorioServices {
	
	@EJB
	private ConsultorioFacade<Cliente> facade;

	/**
	 * metodo que se encarga de listar todos los clientes existentes en la base de
	 * datos
	 * 
	 * @return
	 * @throws Exception
	 */
	public List<Cliente> listClient() throws Exception {
		return facade.listClients();
	}

	/**
	 * busca un cliente por su numero de documento
	 * 
	 * @param document
	 * @return
	 * @throws Exception
	 */
	public Cliente searchByDocument(String document) throws Exception {
		return facade.searchByDocument(document);
	}

	public boolean createLawyer(Abogado abogado) throws Exception{
		return facade.createLawyer(abogado);
	}

	public boolean deleteClient(int documento) throws Exception{
		return facade.deleteClient(documento);
	}

	public boolean createCourt(Juzgado juzgado) {
		return facade.createCourt(juzgado);
	}
}
