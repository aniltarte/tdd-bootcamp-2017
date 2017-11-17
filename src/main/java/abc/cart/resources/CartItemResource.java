package abc.cart.resources;

import abc.cart.domain.CartItem;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.Collections;
import java.util.List;

@Path("/cart/{userId}/item")
@Produces(MediaType.APPLICATION_JSON)
public class CartItemResource {
    @POST
    public Response addCartItem() {
        return Response.ok().build();
    }
}
