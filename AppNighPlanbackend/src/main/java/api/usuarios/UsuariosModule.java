package api.usuarios;

import com.google.inject.AbstractModule;
import com.google.inject.multibindings.Multibinder;
import spark.Router;

/**
 *
 * @Javier Altmann
 */
public class UsuariosModule extends AbstractModule {
    @Override
    protected void configure() {
       Multibinder<Router> routerBinder = Multibinder.newSetBinder(binder(), Router.class);
        bind(UsuariosRouter.class);
        routerBinder.addBinding().to(UsuariosRouter.class);

    }
    
}
