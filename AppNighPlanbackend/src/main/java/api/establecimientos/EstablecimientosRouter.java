
package api.establecimientos;

import DAO.DAOException;
import DAO.MysqlDaoManager;
import api.ApiService;
import com.google.gson.Gson;
import conf.Enviroment;
import java.util.List;
import javax.inject.Inject;
import models.CreateUserDTO;
import models.Establecimientos;
import models.EstablecimientosDTO;
import models.UserDTO;
import models.Usuario;
import spark.Router;
import static spark.Spark.before;
import static spark.Spark.get;
import static spark.Spark.options;
import static spark.Spark.post;

/**
 *
 * @author Javier Altmann
 */
public class EstablecimientosRouter implements Router{

     private final EstablecimientosService establecimientosService;
    private MysqlDaoManager connection;

    private final String apiContext = Enviroment.API_CONTEXT.getProperty();
    private final String appVersion = Enviroment.APP_VERSION.getProperty();
    private Gson jsonParser;
    private String response;

    @Inject
    public EstablecimientosRouter(EstablecimientosService establecimientosService, MysqlDaoManager connection) {
        this.establecimientosService = establecimientosService;
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

       

        //ENDPOINT TEST
         get( "/test/", (req, res) -> {
         
          
          try{
          EstablecimientosDTO establecimiento = new EstablecimientosDTO();
          establecimiento.setEstablecimientos(connection.getEstablecimientosDAO().getEstablecimientosDestacados());

          response = jsonParser.toJson(establecimiento);
          res.status(200);
          if (establecimiento.getEstablecimientos().isEmpty()){
              res.status(204);
          }
          
          }catch(Exception ex){
              res.status(500);
              return ex;
          }
            return response;
           }
        );
         
        
          
         
    }
   
    
}
