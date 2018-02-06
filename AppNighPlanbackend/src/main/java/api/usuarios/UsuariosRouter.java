package api.usuarios;

import DAO.MysqlDaoManager;
import com.google.gson.Gson;
import conf.Enviroment;
import javax.inject.Inject;
import models.Usuario;
import spark.Router;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.post;

/**
 *
 * @Javier Altmann
 */
public class UsuariosRouter implements Router{
        
        private final UsuariosService usuariosService;
        private MysqlDaoManager connection;

        private final String apiContext = Enviroment.API_CONTEXT.getProperty();
        private final String appVersion = Enviroment.APP_VERSION.getProperty();
        private Gson jsonParser;
        private String response;

    @Inject
    public UsuariosRouter(UsuariosService usuariosService, MysqlDaoManager connection) {
        this.usuariosService = usuariosService;
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

         post( "/login/", (req, res) -> {
             response = req.body();
             Usuario user = jsonParser.fromJson(response, Usuario.class);
             res.status(200); //Solicitud correcta
            String respuesta = jsonParser.toJson(connection.getUsuariosDAO().autenticacionUsuario(user));
                    
            return respuesta;
           }
        );
         
        
          
         
    }
    
}
    

