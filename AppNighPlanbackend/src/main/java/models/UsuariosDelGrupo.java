package models;

/**
 *
 * @Javier Altmann
 */
public class UsuariosDelGrupo {
    private int id_usuario;
    private String nombre;
    private String apellido;
    private String imagen_perfil;

    public UsuariosDelGrupo(){}

    public UsuariosDelGrupo(int id_usuario, String nombre, String apellido, String imagen_perfil) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.imagen_perfil = imagen_perfil;
    }

    public int getId_usuario() {
        return id_usuario;
    }

    public void setId_usuario(int id_usuario) {
        this.id_usuario = id_usuario;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getImagen_perfil() {
        return imagen_perfil;
    }

    public void setImagen_perfil(String imagen_perfil) {
        this.imagen_perfil = imagen_perfil;
    }
    
    

}
    
   