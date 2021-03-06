
import api.ApiModule;
import api.ApiRouter;
import api.establecimientos.EstablecimientosModule;
import api.grupos.GruposModule;
import api.usuarios.UsuariosModule;
import com.google.inject.AbstractModule;
import com.google.inject.Guice;
import com.google.inject.Injector;

import com.google.inject.multibindings.Multibinder;
import database.DatabaseModule;
import database.DatabaseRouter;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import spark.Router;
import spark.RouterManager;
import spark.Spark;


public final class Main extends AbstractModule {

    static final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String... args) {
        Injector injector = Guice.createInjector(
                
                new ApiModule(),
                new EstablecimientosModule(),
                new UsuariosModule(),
                new GruposModule(),
                new DatabaseModule());

        Spark.port(getHerokuAssignedPort());

        RouterManager routerManager = injector.getInstance(RouterManager.class);
        routerManager.initAllRouters();


    }

    static int getHerokuAssignedPort() {
        ProcessBuilder processBuilder = new ProcessBuilder();
        if (processBuilder.environment().get("PORT") != null) {
            return Integer.parseInt(processBuilder.environment().get("PORT"));
        }
        return 4567;
    }


    @Override
    protected void configure() {
        Multibinder<Router> routerBinder = Multibinder.newSetBinder(binder(), Router.class);

   

        bind(ApiRouter.class);
        routerBinder.addBinding().to(ApiRouter.class);

        bind(DatabaseRouter.class);
        routerBinder.addBinding().to(DatabaseRouter.class);
    }


}
