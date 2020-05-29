package co.com.soapejb.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the caso database table.
 * 
 */
@Entity
@NamedQuery(name="Caso.findAll", query="SELECT c FROM Caso c")
public class Caso implements Serializable {
	private static final long serialVersionUID = 1L;

	private String descripcion;

	@Temporal(TemporalType.DATE)
	private Date fechaInicio;

	@Id
	private int id;

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

	public Caso() {
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

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
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

}