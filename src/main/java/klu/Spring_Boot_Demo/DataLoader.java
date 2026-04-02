package klu.Spring_Boot_Demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class DataLoader {

    @Bean
    CommandLineRunner loadData(ProductRepository repo) {
        return args -> {
            repo.save(new Product("Laptop", "Electronics", 60000));
            repo.save(new Product("Phone", "Electronics", 20000));
            repo.save(new Product("Shirt", "Clothing", 1500));
            repo.save(new Product("Shoes", "Footwear", 3000));
            repo.save(new Product("Watch", "Accessories", 5000));
        };
    }
}