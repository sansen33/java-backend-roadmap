import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class JavaBasicsPractice {
    record Product(Long id, String name, int price) {}

    public static void main(String[] args) {
        List<Product> products = new ArrayList<>();
        products.add(new Product(1L, "Keyboard", 399));
        products.add(new Product(2L, "Mouse", 199));
        products.add(new Product(3L, "Monitor", 1999));

        products.stream()
                .filter(product -> product.price() >= 300)
                .sorted(Comparator.comparing(Product::price))
                .forEach(System.out::println);
    }
}
