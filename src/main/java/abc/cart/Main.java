package abc.cart;

import abc.cart.resources.CartResource;
import io.dropwizard.Application;
import io.dropwizard.setup.Environment;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main extends Application<ShoppingCartConfiguration> {
    private final Logger logger = LoggerFactory.getLogger(Main.class);

    public static void main(String[] args) throws Exception {
        new Main().run(args);
    }

    @Override
    public void run(ShoppingCartConfiguration configuration, Environment environment) throws Exception {
        environment.jersey().register(CartResource.class);

        logger.info(configuration.getAppName() + " application started ...");
    }
}
