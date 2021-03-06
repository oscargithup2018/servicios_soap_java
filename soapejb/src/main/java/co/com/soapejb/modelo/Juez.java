package co.com.soapejb.modelo;

import java.io.Serializable;
import javax.persistence.*;


/**
 * The persistent class for the juez database table.
 * 
 */
@Entity
@NamedQuery(name="Juez.findAll", query="SELECT j FROM Juez j")
public class Juez implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String apellidos;

	private int cedula;

	private String direccion;

	private String email;

	private String nombres;

	private int tarjetap;

	private String telefono;

	//bi-directional many-to-one association to Juzgado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idJusgado")
	private Juzgado juzgado;

	public Juez() {
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

	public String getNombres() {
		return this.nombres;
	}

	public void setNombres(String nombres) {
		this.nombres = nombres;
	}

	public int getTarjetap() {
		return this.tarjetap;
	}

	public void setTarjetap(int tarjetap) {
		this.tarjetap = tarjetap;
	}

	public String getTelefono() {
		return this.telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public Juzgado getJuzgado() {
		return this.juzgado;
	}

	public void setJuzgado(Juzgado juzgado) {
		this.juzgado = juzgado;
	}

}