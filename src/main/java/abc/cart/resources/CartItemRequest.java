package abc.cart.resources;

public class CartItemRequest {
    private String productId;
    private int quantities;

    public CartItemRequest() {
        // for internal use
    }

    public CartItemRequest(String productId, int quantities) {

        this.productId = productId;
        this.quantities = quantities;
    }

    public String getProductId() {
        return productId;
    }

    public int getQuantities() {
        return quantities;
    }
}
