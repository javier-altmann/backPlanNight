package api.usuarios;

import DAO.MysqlDaoManager;
import java.sql.SQLException;

/**
 *
 * @Javier Altmann
 */
public class UsuariosService {
    private MysqlDaoManager connection;  

    public UsuariosService() throws SQLException {
        this.connection = new MysqlDaoManager();
    }
    
}
