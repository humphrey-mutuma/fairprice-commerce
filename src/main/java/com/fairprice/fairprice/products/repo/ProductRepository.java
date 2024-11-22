package com.fairprice.fairprice.products.repo;

import com.fairprice.fairprice.products.dto.AllProductsDto;
import com.fairprice.fairprice.products.dto.ProductDto;
import com.fairprice.fairprice.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Repository

public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(:query) OR p.price = :query")
    List<ProductDto> searchProducts(@Param("query") String query);

    @Query(value = """
            SELECT p.id, p.name, p.price, p.image, p.weight, p.is_halal, p.rating, p.reviews, p.created_at, p.updated_at    
            FROM products p;
            """, nativeQuery = true)
    List<AllProductsDto>  findAllProducts();
}