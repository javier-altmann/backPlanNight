package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.List;
import models.Usuario;

/**
 *
 * @Javier Altmann
 */
public class MysqlDaoManager implements DAOManager {
  private Connection conn;
  private EncuestaDAO encuesta = null;
  private EstablecimientosDAO establecimientos = null;
  private GruposDAO grupos = null;
  private UsuarioDAO usuarios = null;
  private Statement st;
  private ResultSet rs;
  
  public MysqlDaoManager(String host,String username, String password, String database) throws SQLException{
      conn = DriverManager.getConnection("jdbc:mysql://" + host + "/" + database, username, password);
  }

    @Override
    public EstablecimientosDAO getEstablecimientosDAO() {
        if (establecimientos == null){
            encuesta = new EncuestaDAO(conn);
        }
        return establecimientos;
    }

    @Override
    public GruposDAO getGruposDAO() {
        if (grupos == null){
            grupos = new GruposDAO(conn);
        }
        return grupos;
    }

    @Override
    public UsuarioDAO getUsuariosDAO() {
        if (usuarios == null){
            usuarios = new UsuarioDAO(conn);
        }
        return usuarios;
        
    }
    
    
  public static void main(String[] args) throws SQLException,DAOException{
    
      MysqlDaoManager man = new MysqlDaoManager("localhost","root","root","nigthPlan");
       
      List<Usuario> user = man.getUsuariosDAO().obtenerTodos();
      
  }
  
}

    


  

