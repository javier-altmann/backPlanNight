/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author glamit
 */
public class Usuario {
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
