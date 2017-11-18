package abc.cart.repository;

import abc.cart.domain.CartItem;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartRepositoryTest {

    @Test
    public void itShouldAddCartItemToACart(){
        CartRepository cartRepository = new CartRepository();

        CartItem cartItem = new CartItem("dove soap", 1);
        cartRepository.add(cartItem);

        assertEquals("dove soap",
                cartRepository.getAllCartItem().get(0).getCartItemName());
    }

}