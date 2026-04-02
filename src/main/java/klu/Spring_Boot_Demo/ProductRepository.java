package klu.Spring_Boot_Demo;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import java.util.List;

public interface ProductRepository extends JpaRepository<Product, Long> {

    // Derived queries
    List<Product> findByCategory(String category);

    List<Product> findByPriceBetween(double min, double max);

    // JPQL queries

    // a. Sorting products by price
    @Query("SELECT p FROM Product p ORDER BY p.price ASC")
    List<Product> getAllSortedByPrice();

    // b. Fetching products above price
    @Query("SELECT p FROM Product p WHERE p.price > :price")
    List<Product> getExpensiveProducts(@Param("price") double price);

    // c. Fetching by category
    @Query("SELECT p FROM Product p WHERE p.category = :category")
    List<Product> getByCategory(@Param("category") String category);
}