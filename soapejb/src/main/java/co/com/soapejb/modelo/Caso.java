package co.com.soapejb.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;
import java.util.List;


/**
 * The persistent class for the caso database table.
 * 
 */
@Entity
@NamedQuery(name="Caso.findAll", query="SELECT c FROM Caso c")
public class Caso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fechaInicio;

	//bi-directional many-to-one association to Abogado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idAbogado")
	private Abogado abogado;

	//bi-directional many-to-one association to Cliente
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idCliente")
	private Cliente cliente;

	//bi-directional many-to-one association to Juzgado
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idJuzgado")
	private Juzgado juzgado;

	//bi-directional many-to-one association to Serviciocaso
	@OneToMany(mappedBy="caso")
	private List<Serviciocaso> serviciocasos;

	public Caso() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDescripcion() {
		return this.descripcion;
	}

	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}

	public Date getFechaInicio() {
		return this.fechaInicio;
	}

	public void setFechaInicio(Date fechaInicio) {
		this.fechaInicio = fechaInicio;
	}

	public Abogado getAbogado() {
		return this.abogado;
	}

	public void setAbogado(Abogado abogado) {
		this.abogado = abogado;
	}

	public Cliente getCliente() {
		return this.cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Juzgado getJuzgado() {
		return this.juzgado;
	}

	public void setJuzgado(Juzgado juzgado) {
		this.juzgado = juzgado;
	}

	public List<Serviciocaso> getServiciocasos() {
		return this.serviciocasos;
	}

	public void setServiciocasos(List<Serviciocaso> serviciocasos) {
		this.serviciocasos = serviciocasos;
	}

	public Serviciocaso addServiciocaso(Serviciocaso serviciocaso) {
		getServiciocasos().add(serviciocaso);
		serviciocaso.setCaso(this);

		return serviciocaso;
	}

	public Serviciocaso removeServiciocaso(Serviciocaso serviciocaso) {
		getServiciocasos().remove(serviciocaso);
		serviciocaso.setCaso(null);

		return serviciocaso;
	}

}