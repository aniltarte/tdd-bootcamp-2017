package abc.cart.repository;

import abc.cart.domain.CartItem;
import abc.cart.resources.CartResource;

import java.util.ArrayList;
import java.util.List;

public class CartRepository {
    private List<CartItem> cartItems = new ArrayList<>();

    public void add(CartItem cartItem) {
        cartItems.add(cartItem);
    }

    public List<CartItem> getAllCartItem() {
        return cartItems;
    }
}
