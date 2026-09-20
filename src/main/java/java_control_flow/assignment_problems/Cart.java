public class Cart {

    private final double[] itemPrices;
    private int itemCount;
    private final String cartId;

    public Cart(String cartId, int maximumItems) {
        this.cartId = cartId;
        this.itemPrices = new double[maximumItems];
        this.itemCount = 0;
    }

    public void addItem(double price) {

        if (itemCount >= itemPrices.length) {
            System.out.println("Item rejected: cart is full");
            return;
        }

        if (price < 0) {
            System.out.println("Item rejected: price cannot be negative");
            return;
        }

        itemPrices[itemCount] = price;
        itemCount++;

        System.out.println("Item added: " + price);
    }

    public double getTotal() {

        double total = 0;

        for (int i = 0; i < itemCount; i++) {
            total += itemPrices[i];
        }

        return total;
    }

    public int getItemCount() {
        return itemCount;
    }

    public static void main(String[] args) {

        Cart cart = new Cart("CART-5", 20);

        cart.addItem(250);
        cart.addItem(99);
        cart.addItem(151);

        System.out.println("Total: " + cart.getTotal());
        System.out.println("Item count: " + cart.getItemCount());
    }
}
