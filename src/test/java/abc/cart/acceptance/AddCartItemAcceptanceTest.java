package abc.cart.acceptance;

import abc.cart.Main;
import abc.cart.ShoppingCartConfiguration;
import abc.cart.domain.CartItem;
import abc.cart.resources.CartItemRequest;
import io.dropwizard.testing.ResourceHelpers;
import io.dropwizard.testing.junit.DropwizardAppRule;
import org.glassfish.jersey.client.JerseyClient;
import org.glassfish.jersey.client.JerseyClientBuilder;
import org.junit.ClassRule;
import org.junit.Test;

import javax.ws.rs.client.Entity;
import javax.ws.rs.core.GenericType;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class AddCartItemAcceptanceTest {

    @ClassRule
    public static final DropwizardAppRule<ShoppingCartConfiguration> RULE = new DropwizardAppRule<>(Main.class, ResourceHelpers.resourceFilePath("app-config.yml"));

    private JerseyClient jerseyClient = new JerseyClientBuilder().build();

    @Test
    public void itShouldAddCartItemToACart() {
        CartItemRequest cartItemRequest = new CartItemRequest("dove soap", 1);

        Response response = jerseyClient.target(getBaseUrl() + "/cart/anilt/item").request()
                .post(Entity.entity(cartItemRequest, MediaType.APPLICATION_JSON_TYPE));

        assertEquals(200, response.getStatus());

        List<CartItem> addedCartItems = jerseyClient.target(getBaseUrl() + "/cart/anilt").request().get(toCartItemList());

        assertEquals(1, addedCartItems.size());
        assertEquals("dove soap", addedCartItems.get(0).getCartItemName());
    }

    @Test
    public void itShouldDeleteCartItemFromACart() {
        saveCartItem();

        //when
        Response response = jerseyClient.target(getBaseUrl() + "/cart/anilt/item/dove-soap")
                .request().delete();
        assertEquals(200, response.getStatus());

        List<CartItem> addedCartItems = jerseyClient.target(getBaseUrl() + "/cart/anilt").request().get(toCartItemList());
        assertEquals(0, addedCartItems.size());
    }

    private void saveCartItem() {
        CartItemRequest cartItemRequest = new CartItemRequest("dove-soap", 1);

        Response saveResponse = jerseyClient.target(getBaseUrl() + "/cart/anilt/item").request()
                .post(Entity.entity(cartItemRequest, MediaType.APPLICATION_JSON_TYPE));

        assertEquals(200, saveResponse.getStatus());
    }


    private GenericType<List<CartItem>> toCartItemList() {
        return new GenericType<List<CartItem>>(){};
    }

    private String getBaseUrl() {
        return String.format("http://localhost:%d", RULE.getLocalPort());
    }
}
