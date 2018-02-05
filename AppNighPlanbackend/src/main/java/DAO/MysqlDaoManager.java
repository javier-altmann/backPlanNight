package DAO;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


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
  
  //parametros de constructor String host,String username, String password, String database
  public MysqlDaoManager() throws SQLException{
     conn = DriverManager.getConnection("jdbc:mysql://localhost/nigthPlan","root","");
     conn.setAutoCommit(false);
  }

   

    @Override
    public EstablecimientosDAO getEstablecimientosDAO() {
        if (establecimientos == null){
            establecimientos = new EstablecimientosDAO(conn);
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
    
     public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }
    
}

    


  

