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
  private EncuestaMysqlDAO encuesta = null;
  private EstablecimientoMysqlDAO establecimientos = null;
  private GruposMysqlDAO grupos = null;
  private UsuarioMysqlDAO usuarios = null;
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
            establecimientos = new EstablecimientosMysqlDAO(conn);
        }
        return establecimientos;
    }

    @Override
    public GruposDAO getGruposDAO() {
        if (grupos == null){
            grupos = new GruposMysqlDAO(conn);
        }
        return grupos;
    }

    @Override
    public UsuarioDAO getUsuariosDAO() {
        if (usuarios == null){
            usuarios = new UsuarioMysqlDAO(conn);
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

    


  

