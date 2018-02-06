package models;

/**
 *
 * @Javier Altmann
 */
public class Usuario {
    private int id_usuario;
    private String nombre;
    private String apellido;
    private String mail;
    private String password;
    private String imagen_perfil;

    public Usuario(String nombre, String apellido, String mail, String password, String imagen_perfil) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.password = password;
        this.imagen_perfil = imagen_perfil;
    }
    
    public Usuario(int id_usuario, String nombre, String apellido, String mail, String imagen_perfil) {
        this.id_usuario = id_usuario;
        this.nombre = nombre;
        this.apellido = apellido;
        this.mail = mail;
        this.password = password;
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

    public String getMail() {
        return mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getImagen_perfil() {
        return imagen_perfil;
    }

    public void setImagen_perfil(String imagen_perfil) {
        this.imagen_perfil = imagen_perfil;
    }
    
    
    
}
