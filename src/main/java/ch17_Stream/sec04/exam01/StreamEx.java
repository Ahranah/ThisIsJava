package ch17_Stream.sec04.exam01;

import java.util.stream.Stream;
import java.util.ArrayList;
import java.util.List;

public class StreamEx {
    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();

        for (int i = 0; i <=5; i++) {
            Product product = new Product(i, "상품"+i, "멋진회사", (int)(10000*Math.random()));
            products.add(product);
        }

        Stream<Product> stream = products.stream();
        stream.forEach(p -> System.out.println(p));
    }
}
