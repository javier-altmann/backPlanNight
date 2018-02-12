package api.usuarios;

import DAO.MysqlDaoManager;
import com.google.gson.Gson;
import conf.Enviroment;
import javax.inject.Inject;
import models.CreateUserDTO;
import models.UserDTO;
import spark.Router;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.post;

/**
 *
 * @Javier Altmann
 */
public class UsuariosRouter implements Router {

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

        post("/login/", (req, res) -> {
            try {
                response = req.body();
                CreateUserDTO user = jsonParser.fromJson(response, CreateUserDTO.class);
                res.status(200); //Solicitud correcta


                String respuesta = jsonParser.toJson(connection.getUsuariosDAO().autenticacionUsuario(user));
               
                //Cuando la query no encuentra por usuario o contrase�a devuelve id_usuario = 0
                if (user.getId_usuario() == 0) {
                    res.status(401);
                    return "No hay resultados";
                }
                
                res.status(201);
                return respuesta;
            } catch (Exception exc) {
                res.status(400);
                return exc;

            }
        }
        );
        
          get("/usuarios/", (req, res) -> {
            try {
                UserDTO usuario = new UserDTO();
                usuario.setUsuarios(connection.getUsuariosDAO().obtenerTodos());
                response = jsonParser.toJson(usuario);
                res.status(200);
                if (usuario.getUsuarios().isEmpty()) {
                    res.status(204); // No hay datos que devolver
                }

            } catch (Exception ex) {
                res.status(500);
                return ex;
            }
            return response;
        }
        );

    }

    

}
