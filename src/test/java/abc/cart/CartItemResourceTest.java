package abc.cart;

import abc.cart.domain.CartItem;
import abc.cart.repository.CartRepository;
import abc.cart.resources.CartItemRequest;
import abc.cart.resources.CartItemResource;
import org.junit.Assert;
import org.junit.Test;
import org.mockito.Mock;

import javax.ws.rs.core.Response;

import static org.junit.Assert.assertEquals;
import static org.mockito.Matchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

public class CartItemResourceTest {

    @Test
    public void itShouldAddCartItemToACart(){
        //given
        CartRepository cartRepository = mock(CartRepository.class);
        CartItemResource cartItemResource = new CartItemResource(cartRepository);
        CartItemRequest doveSoap = new CartItemRequest("dove soap", 1);

        //when
        Response response = cartItemResource.addCartItem(doveSoap);

        //then
        assertEquals(200, response.getStatus());
        verify(cartRepository, times(1)).add(any(CartItem.class));
    }
}
