import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.UUID;
import java.util.function.Supplier;

public class Main {
    public static void main(String[] args) {
        ProductManager productManager = new ProductManager();
        // Ürünlerin eklenmesi
        productManager.addProduct(new Product("1", "Product 1", 10, 9.99, "Category 1", ProductStatus.ACTIVE));
        productManager.addProduct(new Product("2", "Product 2", 5, 14.99, "Category 2", ProductStatus.ACTIVE));
        productManager.addProduct(new Product("3", "Product 3", 0, 19.99, "Category 1", ProductStatus.OUT_OF_STOCK));
        
        // getActiveProductsSortedByPrice fonksiyonunun çağrılması küçükten büyüğe artan sıralama
        List<Product> activeProductsSortedByPrice = productManager.getActiveProductsSortedByPrice();
        System.out.println("Active products sorted by price:");
        for (Product product : activeProductsSortedByPrice) {
            System.out.println(product.getName() + " - " + product.getPrice());
        }
        
        // calculateAveragePriceInCategory fonksiyonunun çağrılması  2 category için test edildi
        String category = "Category 1";
        String category2 = "Category 2";

        double averagePrice = productManager.calculateAveragePriceInCategory(category);
        System.out.println("Average price in category " + category + ": " + averagePrice);
        
        //FOR CATEGORY2
        double averagePrice2 = productManager.calculateAveragePriceInCategory(category2);
        System.out.println("Average price in category " + category2 + ": " + averagePrice2);
        
        // getCategoryPriceSum fonksiyonunun çağrılması
        Map<String, Double> categoryPriceSum = productManager.getCategoryPriceSum();
        System.out.println("Category price sum:");
        for (Map.Entry<String, Double> entry : categoryPriceSum.entrySet()) {
            System.out.println(entry.getKey() + " - " + entry.getValue());
        }
    }
}
