package ch17_Stream.cartItem;

import java.util.List;
import java.util.stream.Collectors;

public class CartStream {
    public static void main(String[] args) {
        List<CartItem> cartItemList = CartItem_Dummy.getCartItemList();
//        try (BufferedReader br = new BufferedReader(new FileReader("src/java/ch17Stream/cartItem/CartItem_Dummy_Data.csv"))) {
//            String line;
//            br.readLine();
//            while ((line = br.readLine()) != null) {
//                String[] values = line.split(",");
//                String name = values[0];
//                String category = values[1];
//                int price = Integer.parseInt(values[2]);
//                int stock = Integer.parseInt(values[3]);
//                boolean isOnSale = Boolean.parseBoolean(values[4]);
//
//                CartItem item = new CartItem(name, category, price, stock, isOnSale);
//                cartItemList.add(item);
//            }
//        } catch(Exception e) {
//                e.printStackTrace();
//        }
//
//        cartItemList.forEach(cartItem -> {
//            System.out.print(cartItem.getName() + ",");
//        });


        System.out.println("\n=== 같은 카테고리에 가격이 더 싼 제품 내림차순 ===");
        filterByCategoryPrice(cartItemList, "뷰티").forEach(System.out::println);

        System.out.println("\n=== 5개 이하 제품 ===");
        filterByStockUnder(cartItemList, 5).forEach(System.out::println);

        System.out.println("\n=== 할인중인 제품 ===");
        filterByOnSale(cartItemList).forEach(System.out::println);


    }

        // 같은 카테고리에 가격이 더 싼 제품 내림차순
        public static List<CartItem> filterByCategoryPrice(List<CartItem> items, String category) {
            return items.stream().filter(item ->item.getCategory().equals(category))
            .sorted((a,b) -> Integer.compare(b.getPrice(), a.getPrice()))
            .collect(Collectors.toList());
        }

        // 5개 이하 제품
        public static List<CartItem> filterByStockUnder(List<CartItem> items, int maxStock) {
            return items.stream().filter(item -> item.getStock() <= maxStock)
                    .collect(Collectors.toList());
        }

        // 할인중인 제품
        public static List<CartItem> filterByOnSale(List<CartItem> items) {
            return items.stream().filter(CartItem::isOnSale).collect(Collectors.toList());
        }

    }

