package ch17_Stream.cartItem;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class CartItem {
    String name;
    String category;
    int price;
    int stock;
    boolean isOnSale;

    @Override
    public String toString() {
        return "CartItem{name='" + name + "', category='" + category +
                "', price=" + price + ", stock=" + stock +
                ", isOnSale=" + (isOnSale ? "Discount" : "Regular Price") + '}';
    }
}
