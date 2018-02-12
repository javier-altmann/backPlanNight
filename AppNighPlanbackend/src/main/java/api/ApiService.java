package api;

import DAO.MysqlDaoManager;
import java.sql.SQLException;

public class ApiService {

    private MysqlDaoManager connection;

    public ApiService() throws SQLException {
        this.connection = new MysqlDaoManager();
    }

}
