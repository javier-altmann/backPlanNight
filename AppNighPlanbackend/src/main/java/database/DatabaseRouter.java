package database;

import DAO.MysqlDaoManager;
import spark.Router;
import spark.Spark;

import javax.inject.Inject;

public class DatabaseRouter implements Router {

    private MysqlDaoManager connection;
   

    @Inject
    public DatabaseRouter(MysqlDaoManager connection) {
        this.connection = connection;
    }

    @Override
    public void routeServices() {

        Spark.get("/database/healthcheck", (req, res) ->
                
                connection.getConn().isClosed() ? "Sin conexión" : "Conx conexión"
        );


    }

}
