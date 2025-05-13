package ch17_Stream.sec04.exam01;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Product {
    private int pno;
    private String name;
    private String company;
    private int price;

    @Override
    public String toString() {
        return new StringBuilder()
                .append("pno: " + pno + ", ")
                .append("name: " + name + ", ")
                .append("company: " + company + ", ")
                .append("price: " + price)
                .toString();
    }
}
