/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Usuario;

/**
 *
 * @Javier Altmann
 */
public class UsuarioDAO implements BaseDAO{

    final String GETALL = "SELECT * FROM usuarios";
    private Connection conn;
    final String AUTENTICACION = "SELECT usuarios.id_usuario, usuarios.nombre, usuarios.apellido, usuarios.mail, usuarios.imagen_perfil  FROM usuarios WHERE mail = ? AND password = ?";
    
   public UsuarioDAO(Connection conn){
       this.conn = conn;
   }
   
    @Override
    public void crear(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Object t) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List obtenerTodos() throws DAOException {
        PreparedStatement stat = null;
        ResultSet rs = null;
        List<Usuario> user = new ArrayList<>();
        try{
            stat = conn.prepareStatement(GETALL);
            rs = stat.executeQuery();
            
            while(rs.next()){
                user.add(parseObject(rs));
            }
        }catch(SQLException ex){
          throw new DAOException("Error en la conexion a la base de datos",ex);
        }finally{
            if(rs != null){
              try{
                  rs.close();
              }catch(SQLException ex){
                 throw new DAOException("Error en la conexion a la base de datos",ex); 
              } 
              
            if(stat != null){
              try{
                  stat.close();
              }catch(SQLException ex){
                  
              }  
            }
        }
        
        
       
    }
         return user;
    }
    @Override
    public Object obtener(int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public Usuario autenticacionUsuario(Usuario user) throws DAOException, SQLException{
        PreparedStatement stat = null;
        ResultSet rs = null;
        
        
        
        try{
            stat = conn.prepareStatement(AUTENTICACION);
            stat.setString(1, user.getMail());
            stat.setString(2, user.getPassword());
            rs   = stat.executeQuery();
            
            while(rs.next()){
               
             parseUserLoginObject(rs,user);
            }
        }catch(SQLException ex){
            throw new DAOException("Error en la query",ex);
        }finally{
             if(rs != null){
              try{
                  rs.close();
              }catch(SQLException ex){
                 throw new DAOException("Error en la conexion a la base de datos",ex); 
              } 
              
            if(stat != null){
              try{
                  stat.close();
              }catch(SQLException ex){
                  
              }  
            }
        }
        
        }
       return user;
    }
    
    private Usuario parseObject(ResultSet rs) throws SQLException{
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        String mail = rs.getString("mail");
        String password = rs.getString("password");
        String imagen_perfil = rs.getString("imagen_perfil");
        Usuario user = new Usuario(nombre,apellido,mail,password,imagen_perfil);
        return user;
    
    }
    
    private Usuario parseUserLoginObject(ResultSet rs,Usuario user) throws SQLException{
        user.setId_usuario(rs.getInt("id_usuario"));
        user.setNombre(rs.getString("nombre")); 
        user.setApellido(rs.getString("apellido"));
        user.setMail(rs.getString("mail"));
        user.setImagen_perfil(rs.getString("imagen_perfil")); 
        
        return user;
    }
    
    
    
        
    
}
