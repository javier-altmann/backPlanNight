package api;

import DAO.MysqlDaoManager;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import conf.Enviroment;
import java.util.List;
import models.*;


import javax.inject.Inject;
import org.json.JSONObject;

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
    public ApiRouter(ApiService apiService, MysqlDaoManager connection) {
        this.apiService = apiService;
        this.connection = connection;
        this.jsonParser = new Gson();
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
             UserDTO usuario = new UserDTO();
             usuario.setUsuarios(connection.getUsuariosDAO().obtenerTodos());
           
           
            response = jsonParser.toJson(usuario) ;
               
            return response;
           }
        );

    }
}
