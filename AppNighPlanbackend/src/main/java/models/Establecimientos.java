package models;

/**
 *
 * @author Javier Altmann
 */
public class Establecimientos {
    private int id_establecimiento;
    private String nombre;
    private String imagen;
    private String direccion;
    private String barrio;
    private boolean destacado;

    public Establecimientos(int id_establecimiento, String nombre, String imagen, String direccion, String barrio, boolean destacado) {
        this.id_establecimiento = id_establecimiento;
        this.nombre = nombre;
        this.imagen = imagen;
        this.direccion = direccion;
        this.barrio = barrio;
        this.destacado = destacado;
    }

   

    public String getBarrio() {
        return barrio;
    }

    public void setBarrio(String barrio) {
        this.barrio = barrio;
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
