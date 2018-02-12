package api.establecimientos;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import spark.Router;

/**
 *
 * @author Javier Altmann
 */
public class EstablecimientosModule extends AbstractModule {
    @Override
    protected void configure() {
       Multibinder<Router> routerBinder = Multibinder.newSetBinder(binder(), Router.class);
        bind(EstablecimientosRouter.class);
        routerBinder.addBinding().to(EstablecimientosRouter.class);

    }
    
}
