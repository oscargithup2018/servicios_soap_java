package co.com.soapejb.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the cliente database table.
 * 
 */
@Entity
@NamedQuery(name="Cliente.findAll", query="SELECT c FROM Cliente c")
public class Cliente implements Serializable {
	private static final long serialVersionUID = 1L;

	public static final String SEARCH_CLIENTS = "Cliente.SEARCH_CLIENTS";
	public static final String SEARCH_CLIENT_DOCUMENT = "Cliente.SEARCH_CLIENT_DOCUMENT";

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String apellidos;

	private int cedula;

	private String direccion;

	private String email;

	private int estrato;

	private int ingresos;

	private String nombres;

	private String telefono;

	//bi-directional many-to-one association to Caso
	@OneToMany(mappedBy="cliente", fetch = FetchType.EAGER)
	private List<Caso> casos;

	public Cliente() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getApellidos() {
		return this.apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public int getCedula() {
		return this.cedula;
	}

	public void setCedula(int cedula) {
		this.cedula = cedula;
	}

	public String getDireccion() {
		return this.direccion;
	}

	public void setDireccion(String direccion) {
		this.direccion = direccion;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getEstrato() {
		return this.estrato;
	}

	public void setEstrato(int estrato) {
		this.estrato = estrato;
	}

	public int getIngresos() {
		return this.ingresos;
	}

	public void setIngresos(int ingresos) {
		this.ingresos = ingresos;
	}

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public List<Caso> getCasos() {
		return this.casos;
	}

	public void setCasos(List<Caso> casos) {
		this.casos = casos;
	}

	public Caso addCaso(Caso caso) {
		getCasos().add(caso);
		caso.setCliente(this);

		return caso;
	}

	public Caso removeCaso(Caso caso) {
		getCasos().remove(caso);
		caso.setCliente(null);

		return caso;
	}

}