package co.com.soapejb.modelo;

import java.io.Serializable;
import javax.persistence.*;
import java.util.List;


/**
 * The persistent class for the juzgado database table.
 * 
 */
@Entity
@NamedQuery(name="Juzgado.findAll", query="SELECT j FROM Juzgado j")
public class Juzgado implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;

	private String asistente;

	private String secretario;

	private String tipo;

	//bi-directional many-to-one association to Caso
	@OneToMany(mappedBy="juzgado")
	private List<Caso> casos;

	//bi-directional many-to-one association to Juez
	@OneToMany(mappedBy="juzgado")
	private List<Juez> juezs;

	public Juzgado() {
	}

	public int getId() {
		return this.id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getAsistente() {
		return this.asistente;
	}

	public void setAsistente(String asistente) {
		this.asistente = asistente;
	}

	public String getSecretario() {
		return this.secretario;
	}

	public void setSecretario(String secretario) {
		this.secretario = secretario;
	}

	public String getTipo() {
		return this.tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Caso> getCasos() {
		return this.casos;
	}

	public void setCasos(List<Caso> casos) {
		this.casos = casos;
	}

	public Caso addCaso(Caso caso) {
		getCasos().add(caso);
		caso.setJuzgado(this);

		return caso;
	}

	public Caso removeCaso(Caso caso) {
		getCasos().remove(caso);
		caso.setJuzgado(null);

		return caso;
	}

	public List<Juez> getJuezs() {
		return this.juezs;
	}

	public void setJuezs(List<Juez> juezs) {
		this.juezs = juezs;
	}

	public Juez addJuez(Juez juez) {
		getJuezs().add(juez);
		juez.setJuzgado(this);

		return juez;
	}

	public Juez removeJuez(Juez juez) {
		getJuezs().remove(juez);
		juez.setJuzgado(null);

		return juez;
	}

}