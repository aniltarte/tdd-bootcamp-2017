package abc.cart.repository;

import abc.cart.domain.CartItem;
import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class CartRepositoryTest {
    private CartRepository cartRepository = new CartRepository();

    @Test
    public void itShouldAddCartItemToACart() {
        CartItem cartItem = new CartItem("dove soap", 1);
        cartRepository.add(cartItem);

        assertEquals("dove soap",
                cartRepository.getAllCartItem().get(0).getCartItemName());
    }

    @Test
    public void itShouldDeleteCartItemFromACart() {
        CartItem cartItem = new CartItem("dove-soap", 1);
        cartRepository.add(cartItem);

        assertEquals(1, cartRepository.getAllCartItem().size());

        //when
        cartRepository.delete("dove-soap");

        assertEquals(0, cartRepository.getAllCartItem().size());
    }

    @Test(expected = RuntimeException.class)
    public void itShouldThrowAnException_WhenCartItemIsNotInCart() {
        //when
        cartRepository.delete("dove-soap");
    }
}