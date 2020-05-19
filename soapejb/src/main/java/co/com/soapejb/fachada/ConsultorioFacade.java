package co.com.soapejb.fachada;

import java.util.List;

import javax.ejb.Remote;

import co.com.soapejb.modelo.Cliente;

@Remote
public interface ConsultorioFacade<T> {
 
	/**
	 * Método que se encarga de listar todos los clientes
	 * @param <T>
	 * @return
	 * @throws Exception
	 */
	public <T> List<T> listClients() throws Exception;
	
	public T searchByDocument(String document) throws Exception;

}
