package abc.cart.domain;

public class CartItem {

    private String cartItemName;
    private int quantity;

    public CartItem() {
    }

    public CartItem(String cartItemName, int quantity) {
        this.cartItemName = cartItemName;
        this.quantity = quantity;
    }

    public String getCartItemName() {
        return cartItemName;
    }

    public int getQuantity() {
        return quantity;
    }
}
