package MysqlDAO;

import DAO.DAOException;
import DAO.GruposDAO;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import models.UsuariosDelGrupo;
import models.UsersInGroup;

/**
 *
 * @Javier Altmann
 */
public class GruposMysqlDAO implements GruposDAO {

    final String GETUSUARIOSPORGRUPO = "SELECT usuarios.id_usuario, usuarios.nombre, usuarios.apellido, usuarios.imagen_perfil FROM grupos \n"
            + "INNER JOIN grupos_usuarios \n"
            + "ON grupos.id_grupo = grupos_usuarios.id_grupo \n"
            + "INNER JOIN usuarios \n"
            + "ON usuarios.id_usuario = grupos_usuarios.id_usuarios\n"
            + "WHERE grupos.id_grupo = ?";
    final String GETGRUPOSDELUSUARIO = "SELECT grupos.id_grupo,grupos.nombre, grupos.imagen,grupos.fecha_creacion \n"
            + "FROM grupos INNER JOIN grupos_usuarios \n"
            + "ON grupos.id_grupo = grupos_usuarios.id_grupo\n"
            + "INNER JOIN usuarios \n"
            + "ON usuarios.id_usuario = grupos_usuarios.id_usuarios WHERE id_usuario = ?";
    
    private Connection conn;
    private PreparedStatement stat;
    private ResultSet rs = null;
    

    public GruposMysqlDAO(Connection conn) {
        this.conn = conn;
    }

    @Override
    public void crear(Object t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }


    @Override
    public void actualizar(Object t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void eliminar(Object t) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List obtenerTodos() throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Object obtener(int id) throws DAOException {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public List<UsersInGroup> getGruposDelUsuario(int id_grupo) throws DAOException {
        List<UsersInGroup> usersInGroup = new ArrayList<>();
        
        try{
            stat = conn.prepareStatement(GETGRUPOSDELUSUARIO);
            stat.setInt(1, id_grupo);
            rs = stat.executeQuery();
            
            while(rs.next()){
                usersInGroup.add(parseObjectUsersInGroup(rs));
            }
            
        }catch(Exception ex){
        
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
        return usersInGroup;
    }

    @Override
    public List<UsuariosDelGrupo> getUsuariosDelGrupos(int id_usuario) throws DAOException {
         List<UsuariosDelGrupo> usuariosDelGrupo = new ArrayList<>();
        
        try{
            stat = conn.prepareStatement(GETUSUARIOSPORGRUPO);
            stat.setInt(1, id_usuario);
            rs = stat.executeQuery();
             while(rs.next()){
                usuariosDelGrupo.add(parseObjectGroup(rs));
            }
            
        }catch(Exception ex){
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
        return usuariosDelGrupo;
    
    }
    
      private UsuariosDelGrupo parseObjectGroup(ResultSet rs) throws SQLException{
          
        int id_usuario = rs.getInt("id_usuario");
        String nombre = rs.getString("nombre");
        String apellido = rs.getString("apellido");
        String imagen_perfil = rs.getString("imagen_perfil");
        
     
        UsuariosDelGrupo usuariosDelgrupo = new UsuariosDelGrupo(id_usuario,nombre,apellido,imagen_perfil);
        return usuariosDelgrupo;
    
    }
      
       private UsersInGroup parseObjectUsersInGroup(ResultSet rs) throws SQLException{
        
        int id_grupo = rs.getInt("id_grupo");
        String nombre = rs.getString("nombre");
        String imagen_perfil = rs.getString("imagen");
        String fecha_creacion = rs.getString("fecha_creacion");
     
        UsersInGroup usersInGroup = new UsersInGroup(id_grupo,nombre,imagen_perfil,fecha_creacion);
        return usersInGroup;
    
    }

}
