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

	private int idcaso;

	private int idservicio;

	//bi-directional many-to-one association to Factura
	@OneToMany(mappedBy="serviciocaso")
	private List<Factura> facturas;

	public Serviciocaso() {
	}

	public int getIdServicioCaso() {
		return this.idServicioCaso;
	}

	public void setIdServicioCaso(int idServicioCaso) {
		this.idServicioCaso = idServicioCaso;
	}

	public int getIdcaso() {
		return this.idcaso;
	}

	public void setIdcaso(int idcaso) {
		this.idcaso = idcaso;
	}

	public int getIdservicio() {
		return this.idservicio;
	}

	public void setIdservicio(int idservicio) {
		this.idservicio = idservicio;
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

}