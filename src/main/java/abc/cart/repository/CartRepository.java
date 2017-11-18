package abc.cart.repository;

import abc.cart.domain.CartItem;
import abc.cart.resources.CartResource;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CartRepository {
    private List<CartItem> cartItems = new ArrayList<>();

    public void add(CartItem cartItem) {
        cartItems.add(cartItem);
    }

    public List<CartItem> getAllCartItem() {
        return cartItems;
    }

    public void delete(String cartItemName) {
        CartItem cartItem = cartItems.stream()
                .filter(i -> i.getCartItemName().equalsIgnoreCase(cartItemName))
                .findFirst()
                .orElseThrow(()->new RuntimeException(""));

        cartItems.remove(cartItem);
    }
}
