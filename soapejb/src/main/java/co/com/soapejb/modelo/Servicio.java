package co.com.soapejb.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the servicio database table.
 * 
 */
@Entity
@NamedQuery(name="Servicio.findAll", query="SELECT s FROM Servicio s")
public class Servicio implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idServicio;

	private String nombreServicio;

	private int valorServicio;

	//bi-directional many-to-one association to Serviciocaso
	@OneToMany(mappedBy="servicio")
	private List<Serviciocaso> serviciocasos;

	public Servicio() {
	}

	public int getIdServicio() {
		return this.idServicio;
	}

	public void setIdServicio(int idServicio) {
		this.idServicio = idServicio;
	}

	public String getNombreServicio() {
		return this.nombreServicio;
	}

	public void setNombreServicio(String nombreServicio) {
		this.nombreServicio = nombreServicio;
	}

	public int getValorServicio() {
		return this.valorServicio;
	}

	public void setValorServicio(int valorServicio) {
		this.valorServicio = valorServicio;
	}

	public List<Serviciocaso> getServiciocasos() {
		return this.serviciocasos;
	}

	public void setServiciocasos(List<Serviciocaso> serviciocasos) {
		this.serviciocasos = serviciocasos;
	}

	public Serviciocaso addServiciocaso(Serviciocaso serviciocaso) {
		getServiciocasos().add(serviciocaso);
		serviciocaso.setServicio(this);

		return serviciocaso;
	}

	public Serviciocaso removeServiciocaso(Serviciocaso serviciocaso) {
		getServiciocasos().remove(serviciocaso);
		serviciocaso.setServicio(null);

		return serviciocaso;
	}

}