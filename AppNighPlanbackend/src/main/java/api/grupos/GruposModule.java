package api.grupos;

import api.establecimientos.EstablecimientosRouter;
import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import spark.Router;

/**
 *
 * @Javier Altmann
 */
public class GruposModule extends AbstractModule {
    @Override
    protected void configure() {
       Multibinder<Router> routerBinder = Multibinder.newSetBinder(binder(), Router.class);
        bind(GruposRouter.class);
        routerBinder.addBinding().to(GruposRouter.class);

    }
    
}
