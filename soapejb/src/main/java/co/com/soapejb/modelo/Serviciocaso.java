package co.com.soapejb.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the serviciocaso database table.
 * 
 */
@Entity
@NamedQuery(name="Serviciocaso.findAll", query="SELECT s FROM Serviciocaso s")
public class Serviciocaso implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int idServicioCaso;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="serviciocaso")
	private List<Factura> facturas;

	//bi-directional many-to-one association to Caso
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idcaso")
	private Caso caso;

	//bi-directional many-to-one association to Servicio
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idservicio")
	private Servicio servicio;

	public Serviciocaso() {
	}

	public int getIdServicioCaso() {
		return this.idServicioCaso;
	}

	public void setIdServicioCaso(int idServicioCaso) {
		this.idServicioCaso = idServicioCaso;
	}

	public List<Factura> getFacturas() {
		return this.facturas;
	}

	public void setFacturas(List<Factura> facturas) {
		this.facturas = facturas;
	}

	public Factura addFactura(Factura factura) {
		getFacturas().add(factura);
		factura.setServiciocaso(this);

		return factura;
	}

	public Factura removeFactura(Factura factura) {
		getFacturas().remove(factura);
		factura.setServiciocaso(null);

		return factura;
	}

	public Caso getCaso() {
		return this.caso;
	}

	public void setCaso(Caso caso) {
		this.caso = caso;
	}

	public Servicio getServicio() {
		return this.servicio;
	}

	public void setServicio(Servicio servicio) {
		this.servicio = servicio;
	}

}