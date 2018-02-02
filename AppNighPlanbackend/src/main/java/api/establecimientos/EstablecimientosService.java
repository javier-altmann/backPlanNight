package api.establecimientos;

import DAO.MysqlDaoManager;
import java.sql.SQLException;

/**
 *
 * @Javier Altmann
 */
public class EstablecimientosService {
    
    private MysqlDaoManager connection;  

public EstablecimientosService() throws SQLException {
        this.connection = new MysqlDaoManager();
    }
    
}
