package MysqlDAO;

import DAO.DAOException;
import DAO.EstablecimientosDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.Establecimientos;

/**
 *
 * @author JavierAltmann
 */
public class EstablecimientoMysqlDAO implements EstablecimientosDAO {

final String GETESTABLECIMIENTOS = "SELECT establecimientos.id_establecimiento ,establecimientos.nombre, establecimientos.imagen, establecimientos.direccion, \n" +
"barrios.barrio, establecimientos.destacado\n" +
"FROM establecimientos\n" +
"INNER JOIN establecimiento_barrios\n" +
"ON establecimientos.id_establecimiento = establecimiento_barrios.id_establecimiento\n" +
"INNER JOIN barrios \n" +
"ON barrios.id_barrio = establecimiento_barrios.id_barrio\n" +
"WHERE establecimientos.destacado = ?";
   
private Connection conn;
private PreparedStatement stat = null;
private ResultSet rs = null;
    
   public EstablecimientoMysqlDAO(Connection conn){
       this.conn = conn;
   }
   
   @Override
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
    
     private Establecimientos parseObject(ResultSet rs) throws SQLException{
        int id_establecimiento = rs.getInt("id_establecimiento");
        String nombre = rs.getString("nombre");
        String imagen = rs.getString("imagen");
        String direccion = rs.getString("direccion");
        String barrio = rs.getString("barrio");
        boolean destacado = rs.getBoolean("destacado");
     
        Establecimientos establecimiento = new Establecimientos(id_establecimiento,nombre,imagen,direccion,barrio,destacado);
        return establecimiento;
    
    }

    @Override
    public void crear(Establecimientos t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void insertar(Establecimientos t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void actualizar(Establecimientos t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Establecimientos t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<Establecimientos> obtenerTodos() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Establecimientos obtener(int id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
   
}
