package DAO;

import MysqlDAO.EstablecimientoMysqlDAO;
import MysqlDAO.GruposMysqlDAO;
import MysqlDAO.UsuarioMysqlDAO;
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
    public MysqlDaoManager() throws SQLException {
        conn = DriverManager.getConnection("jdbc:mysql://localhost/nigthPlan", "root", "");
        conn.setAutoCommit(false);
    }

    public Connection getConn() {
        return conn;
    }

    public void setConn(Connection conn) {
        this.conn = conn;
    }

    @Override
    public EstablecimientosDAO getEstablecimientosDAO() {
        if (establecimientos == null) {
            establecimientos = new EstablecimientoMysqlDAO(conn);
        }
        return establecimientos;
    }

    @Override
    public GruposDAO getGruposDAO() {
        if (grupos == null) {
            grupos = new GruposMysqlDAO(conn);
        }
        return grupos;
    }

    @Override
    public UsuarioDAO getUsuariosDAO() {
        if (usuarios == null) {
            usuarios = new UsuarioMysqlDAO(conn);
        }
        return usuarios;
    }

}
