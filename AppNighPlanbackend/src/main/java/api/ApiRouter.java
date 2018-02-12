package api;

import DAO.MysqlDaoManager;
import com.google.gson.Gson;
import conf.Enviroment;

import javax.inject.Inject;
import spark.Router;

import static spark.Spark.*;

public class ApiRouter implements Router {

    private final ApiService apiService;
    private MysqlDaoManager connection;

    private final String apiContext = Enviroment.API_CONTEXT.getProperty();
    private final String appVersion = Enviroment.APP_VERSION.getProperty();

    @Inject
    public ApiRouter(ApiService apiService, MysqlDaoManager connection) {
        this.apiService = apiService;
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

    }
}
