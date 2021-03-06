package abc.cart.resources;

import abc.cart.domain.CartItem;
import abc.cart.repository.CartRepository;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Collections;
import java.util.List;

@Path("/cart")
@Produces(MediaType.APPLICATION_JSON)
public class CartResource{
    private CartRepository cartRepository;

    public CartResource(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @GET
    @Path("{userId}")
    public List<CartItem> get(@PathParam("userId")String userName) {
        return cartRepository.getAllCartItem();
    }


}
