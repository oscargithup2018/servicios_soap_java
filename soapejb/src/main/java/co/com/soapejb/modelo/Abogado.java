package co.com.soapejb.modelo;

import javax.persistence.*;
import java.io.Serializable;
import java.util.List;


/**
 * The persistent class for the abogado database table.
 */
@Entity
@NamedQuery(name = "Abogado.findAll", query = "SELECT a FROM Abogado a")
public class Abogado implements Serializable {
    private static final long serialVersionUID = 1L;

    public static final String CREATE_LAWYER = "Abogado.CREATE_LAWYER";


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int cedula;

    private String apellidos;

    private String direccion;

    private String email;

    private String nombres;

    private int tarjetap;

    private String telefono;

    //bi-directional many-to-one association to Caso
    @OneToMany(mappedBy = "abogado")
    private List<Caso> casos;

    public Abogado() {
    }

    public Abogado(String apellidos, String direccion, String email, String nombres, int tarjetap, String telefono) {
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.email = email;
        this.nombres = nombres;
        this.tarjetap = tarjetap;
        this.telefono = telefono;
    }

    public int getCedula() {
        return this.cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getApellidos() {
        return this.apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
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

    public List<Caso> getCasos() {
        return this.casos;
    }

    public void setCasos(List<Caso> casos) {
        this.casos = casos;
    }

    public Caso addCaso(Caso caso) {
        getCasos().add(caso);
        caso.setAbogado(this);

        return caso;
    }

    public Caso removeCaso(Caso caso) {
        getCasos().remove(caso);
        caso.setAbogado(null);

        return caso;
    }

}