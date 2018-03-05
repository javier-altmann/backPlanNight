package api.grupos;

import DAO.MysqlDaoManager;
import api.establecimientos.EstablecimientosService;
import com.google.gson.Gson;
import conf.Enviroment;
import javax.inject.Inject;
import models.UsuariosDelGrupoDTO;
import models.GruposDelUsuarioDTO;
import spark.Router;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.options;

/**
 *
 * @Javier Altmann
 */
public class GruposRouter implements Router {
    private final GruposService gruposService;
    private MysqlDaoManager connection;

    private final String apiContext = Enviroment.API_CONTEXT.getProperty();
    private final String appVersion = Enviroment.APP_VERSION.getProperty();
    private Gson jsonParser;
    private String response;

    @Inject
    public GruposRouter(GruposService gruposService, MysqlDaoManager connection) {
        this.gruposService = gruposService;
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
        
        get("/grupos/usuarios/:id/", (req, res) -> {

            try {
                int id_usuario = Integer.parseInt(req.params(":id"));
                UsuariosDelGrupoDTO grupos = new UsuariosDelGrupoDTO();

                grupos.setGrupos(connection.getGruposDAO().getUsuariosDelGrupos(id_usuario));

                response = jsonParser.toJson(grupos);
                res.status(200);
                if (grupos.getGrupos().isEmpty()) {
                    res.status(204);
                }

            } catch (Exception ex) {
                res.status(500);
                return ex;
            }
            return response;
        }
        );
        
        
        
        
         get("/grupos/:id/", (req, res) -> {

            try {
                int id_grupo = Integer.parseInt(req.params(":id"));
                GruposDelUsuarioDTO grupos = new GruposDelUsuarioDTO();

                grupos.setGrupos(connection.getGruposDAO().getGruposDelUsuario(id_grupo));

                response = jsonParser.toJson(grupos);
                res.status(200);
                if (grupos.getDatosDeLosUsuariosDeLosGrupos().isEmpty()) {
                    res.status(204);
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
