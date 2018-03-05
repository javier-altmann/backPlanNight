package api.grupos;

import DAO.MysqlDaoManager;
import java.sql.SQLException;

/**
 *
 * @Javier Altmann
 */
public class GruposService {
    private MysqlDaoManager connection;

    public GruposService() throws SQLException {
        this.connection = new MysqlDaoManager();
    }
    
}
