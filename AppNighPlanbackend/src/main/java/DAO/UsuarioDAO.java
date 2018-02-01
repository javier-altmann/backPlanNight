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
    
    private Usuario parseObject(ResultSet rs) throws SQLException{
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        String mail = rs.getString("password");
        String password = rs.getString("password");
        String imagen_perfil = rs.getString("imagen_perfil");
        Usuario user = new Usuario(nombre,apellido,mail,password,imagen_perfil);
        return user;
    
    }
    
        
    
}
