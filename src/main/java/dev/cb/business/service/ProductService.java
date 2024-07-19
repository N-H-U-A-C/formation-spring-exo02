package dev.cb.business.service;

import dev.cb.business.domain.Product;
import dev.cb.utils.enums.Category;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class ProductService {

    private final List<Product> products;

    public ProductService() {
        products = new ArrayList<>();
        products.add(new Product(UUID.randomUUID(), "Baguette", Category.FOOD, .75));
        System.out.println("Product created: UUID: " + products.get(0).getId());
        products.add(new Product(UUID.randomUUID(), "Chili con carne", Category.FOOD, 4.50));
        System.out.println("Product created: UUID: " + products.get(1).getId());
        products.add(new Product(UUID.randomUUID(), "T-shirt", Category.FASHION, 14.99));
        System.out.println("Product created: UUID: " + products.get(2).getId());
        products.add(new Product(UUID.randomUUID(), "Flip-flop", Category.FASHION, 5.99));
        System.out.println("Product created: UUID: " + products.get(3).getId());
        products.add(new Product(UUID.randomUUID(), "T-shirt", Category.FASHION, 4.50));
        System.out.println("Product created: UUID: " + products.get(4).getId());
    }

    // je la laisse pour l'exo mais fondue avec la méthode getAllByCategoryAndMaxPrice
//    public List<Product> getAll() {
//        return products;
//    }

    public List<Product> getAllByCategoryAndMaxPrice(Category category, double price) {
        return products.stream()
                .filter(product -> category == null || product.getCategory().equals(category))
                .filter(product -> price == 0.0 || product.getPrice() <= price)
                .toList();
    }

    public Optional<Product> getById(UUID id) {
        return products.stream().filter(product -> product.getId().equals(id)).findFirst();
    }
}
