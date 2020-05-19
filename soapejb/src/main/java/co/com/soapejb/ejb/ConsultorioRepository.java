package co.com.soapejb.ejb;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import co.com.soapejb.fachada.ConsultorioFacade;
import co.com.soapejb.modelo.Caso;
import co.com.soapejb.modelo.Cliente;

@Stateless // Indica que el bean es sin estado, quiere decir solo cuando es invocado
@LocalBean
public class ConsultorioRepository implements ConsultorioFacade {

	@PersistenceContext(unitName = "soapejb") // indica cual es la unidad de persistencia que se va a trabajar, el va al
												// archivo xml de persistence, es decir la ba
	private EntityManager etm; // permite la transaccion sobre la base de datos

	@Override
	public List<Cliente> listClients() throws Exception {
		List<Cliente> clientes = new ArrayList<Cliente>();
		List<Cliente> clientesDos = new ArrayList<Cliente>();

		Query q = etm.createNamedQuery(Cliente.SEARCH_CLIENT);
		clientes = q.getResultList();

		if (clientes.size() > 0) {
			for (Cliente c : clientes) {
				if (c.getCasos().isEmpty()) {
					List<Caso> casos = new ArrayList<Caso>();
					c.setCasos(casos);
				}

				clientesDos.add(c);
			}
		}

		return clientesDos;
	}

	@Override
	public Cliente searchByDocument(String document) throws Exception {
		Cliente c = new Cliente();

		Query q= etm.createNamedQuery(Cliente.SEARCH_CLIENT_DOCUMENT).setParameter("doc", Integer.valueOf(document));

		try {
			c = (Cliente) q.getSingleResult();
			if (c.getCedula() > 0) {
				List<Caso> b = new ArrayList<Caso>();
				c.setCasos(b);
			}
		} catch (NoResultException ex) {
			c = new Cliente();
		}

		return c;
	}

}
