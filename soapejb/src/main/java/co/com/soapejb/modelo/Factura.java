package co.com.soapejb.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.Date;


/**
 * The persistent class for the factura database table.
 * 
 */
@Entity
@NamedQuery(name="Factura.findAll", query="SELECT f FROM Factura f")
public class Factura implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	@Temporal(TemporalType.DATE)
	private Date fechaFactura;

	//bi-directional many-to-one association to Serviciocaso
	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name="idservicioCaso")
	private Serviciocaso serviciocaso;

	public Factura() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getFechaFactura() {
		return this.fechaFactura;
	}

	public void setFechaFactura(Date fechaFactura) {
		this.fechaFactura = fechaFactura;
	}

	public Serviciocaso getServiciocaso() {
		return this.serviciocaso;
	}

	public void setServiciocaso(Serviciocaso serviciocaso) {
		this.serviciocaso = serviciocaso;
	}

}