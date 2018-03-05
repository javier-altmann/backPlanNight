package models;

/**
 *
 * @Javier Altmann
 */
public class UsersInGroup {
    private int id_grupo;
    private String nombre;
    private String imagen_perfil;
    private String fecha_creacion;

    public UsersInGroup(int id_grupo, String nombre, String imagen_perfil, String fecha_creacion) {
        this.id_grupo = id_grupo;
        this.nombre = nombre;
        this.imagen_perfil = imagen_perfil;
        this.fecha_creacion = fecha_creacion;
    }

    public int getId_grupo() {
        return id_grupo;
    }

    public void setId_grupo(int id_grupo) {
        this.id_grupo = id_grupo;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getImagen_perfil() {
        return imagen_perfil;
    }

    public void setImagen_perfil(String imagen_perfil) {
        this.imagen_perfil = imagen_perfil;
    }

    public String getFecha_creacion() {
        return fecha_creacion;
    }

    public void setFecha_creacion(String fecha_creacion) {
        this.fecha_creacion = fecha_creacion;
    }

    
    
    
}
