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
import models.Establecimientos;
import models.Usuario;

/**
 *
 * @Javier Altmann
 */
public class EstablecimientosDAO implements BaseDAO{
    final String GETESTABLECIMIENTOS = "SELECT * FROM establecimientos WHERE destacado = ?";
    private Connection conn;
    private PreparedStatement stat = null;
    private ResultSet rs = null;
    
   public EstablecimientosDAO(Connection conn){
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
    public List obtenerTodos() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public List<Establecimientos> getEstablecimientosDestacados() throws DAOException{
       List<Establecimientos> establecimientos = new ArrayList<>();
        try{
            stat = conn.prepareStatement(GETESTABLECIMIENTOS);
            stat.setBoolean(1, true);
            rs = stat.executeQuery();
            
            while(rs.next()){
                establecimientos.add(parseObject(rs));
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
      return establecimientos;
    }
    @Override
    public Object obtener(int id) {
        
        return null;
    }
    
    
    private Establecimientos parseObject(ResultSet rs) throws SQLException{
        int id_establecimiento = rs.getInt("id_establecimiento");
        String nombre = rs.getString("nombre");
        String direccion = rs.getString("direccion");
        String imagen = rs.getString("imagen");
        boolean destacado = rs.getBoolean("destacado");
     
        Establecimientos establecimiento = new Establecimientos(id_establecimiento,nombre, direccion, imagen, destacado);
        return establecimiento;
    
    }
    
}
