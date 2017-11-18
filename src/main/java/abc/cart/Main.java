package abc.cart;

import abc.cart.repository.CartRepository;
import abc.cart.resources.CartItemResource;
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
        CartRepository cartRepository = new CartRepository();
        environment.jersey().register(new CartResource(cartRepository));
        environment.jersey().register(new CartItemResource(cartRepository));

        logger.info(configuration.getAppName() + " application started ...");
    }
}
