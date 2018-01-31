package api;

import DAO.MysqlDaoManager;
import com.google.gson.Gson;
import conf.Enviroment;
import java.util.List;
import models.*;


import javax.inject.Inject;

import spark.Router;

import static spark.Spark.*;

public class ApiRouter implements Router {

    private final ApiService apiService;
    private MysqlDaoManager connection;

    private final String apiContext = Enviroment.API_CONTEXT.getProperty();
    private final String appVersion = Enviroment.APP_VERSION.getProperty();
    private Gson jsonParser;
    private String response;

    @Inject
    public ApiRouter(ApiService apiService, MysqlDaoManager connection, Gson jsonParser) {
        this.apiService = apiService;
        this.connection = connection;
        this.jsonParser = jsonParser;
    }

    @Override
    public void routeServices() {

        options("/*",
                (request, response) -> {

                    String accessControlRequestHeaders = request
                            .headers("Access-Control-Request-Headers");
                    if (accessControlRequestHeaders != null) {
                        response.header("Access-Control-Allow-Headers",
                                accessControlRequestHeaders);
                    }

                    String accessControlRequestMethod = request
                            .headers("Access-Control-Request-Method");
                    if (accessControlRequestMethod != null) {
                        response.header("Access-Control-Allow-Methods",
                                accessControlRequestMethod);
                    }

                    return "OK";
                });

        before((request, response) -> response.header("Access-Control-Allow-Origin", "*"));

        get("/" + apiContext + "/version/", (req, res) -> appVersion);


        //ENDPOINT TEST
          get( "/test/", (req, res) -> {
           //     response = apiService.getUsuarios(connection.getConnection());
                List<Usuario> user = connection.getUsuariosDAO().obtenerTodos();
                  return user;
            
                }
        );

    }
}
