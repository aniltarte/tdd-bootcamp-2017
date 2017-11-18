package abc.cart.resources;

import abc.cart.domain.CartItem;
import abc.cart.repository.CartRepository;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;

@Path("/cart/{userId}/item")
@Produces(MediaType.APPLICATION_JSON)
public class CartItemResource {
    private CartRepository cartRepository;

    public CartItemResource(CartRepository cartRepository) {
        this.cartRepository = cartRepository;
    }

    @POST
    public Response addCartItem(CartItemRequest cartItemRequest) {
        cartRepository.add(cartItemRequest.toCartItem());

        return Response.ok().build();
    }

    @DELETE
    @Path("{cartItemName}")
    public Response addCartItem(@PathParam("cartItemName") String cartItemName) {
        cartRepository.delete(cartItemName);
        return Response.ok().build();
    }
}
