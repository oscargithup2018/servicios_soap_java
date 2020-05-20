package co.com.soapejb.ejb;

import co.com.soapejb.fachada.ConsultorioFacade;
import co.com.soapejb.modelo.Abogado;
import co.com.soapejb.modelo.Caso;
import co.com.soapejb.modelo.Cliente;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.NoResultException;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.ArrayList;
import java.util.List;

@Stateless // Indica que el bean es sin estado, quiere decir solo cuando es invocado
@LocalBean
public class ConsultorioRepository implements ConsultorioFacade {

    @PersistenceContext(unitName = "soapejb") // indica cual es la unidad de persistencia que se va a trabajar, el va al
    private EntityManager etm; // permite la transaccion sobre la base de datos 	// archivo xml de persistence, es decir la ba


    @Override
    public List<Cliente> listClients() throws Exception {
        List<Cliente> clientes = new ArrayList<Cliente>();
        List<Cliente> clientesDos = new ArrayList<Cliente>();

        Query q = etm.createNamedQuery(Cliente.SEARCH_CLIENT);
        clientes = q.getResultList();

        return clientes;
    }

    @Override
    public Cliente searchByDocument(String document) throws Exception {
        Cliente c = new Cliente();

        Query q = etm.createNamedQuery(Cliente.SEARCH_CLIENT_DOCUMENT).setParameter("doc", Integer.valueOf(document));

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

    @Override
    public boolean createLawyer(Abogado abogado) throws Exception {

//		Query q= etm.createNamedQuery(Abogado.CREATE_LAWYER).setParameter("doc", Integer.valueOf(document));
        boolean flag = false;
        try {
            if (abogado.getNombres() != null && !abogado.getNombres().equals("")) {
                etm.persist(abogado);
                flag = true;
            }

        } catch (NoResultException ex) {
            System.out.println(ex);
        }
        return flag;
    }

    @Override
    public boolean deleteClient(int document) throws Exception {
        Cliente cliente1 = buscarClientePorCedula(document);
        boolean retorno = false;
        if (cliente1.getCedula() > 0) {
            etm.remove(cliente1);
            retorno = true;
        }

        return retorno;
    }

    private Cliente buscarClientePorCedula(int codigo) throws Exception {
        Cliente p = new Cliente();
        p = etm.find(Cliente.class, codigo);
        return p;
    }

}
