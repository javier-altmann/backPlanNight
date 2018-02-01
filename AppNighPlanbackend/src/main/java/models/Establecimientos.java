package models;

/**
 *
 * @author Javier Altmann
 */
public class Establecimientos {
    private int id_establecimiento;
    private String nombre;
    private String direccion;
    private String imagen;
    private boolean destacado;

    public Establecimientos(int id_establecimiento, String nombre, String direccion, String imagen, boolean destacado) {
        this.id_establecimiento = id_establecimiento;
        this.nombre = nombre;
        this.direccion = direccion;
        this.imagen = imagen;
        this.destacado = destacado;
    }

    public int getId_establecimiento() {
        return id_establecimiento;
    }

    public void setId_establecimiento(int id_establecimiento) {
        this.id_establecimiento = id_establecimiento;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
    }

    public boolean getDestacado() {
        return destacado;
    }

    public void setDestacado(boolean destacado) {
        this.destacado = destacado;
    }

    
    
}
