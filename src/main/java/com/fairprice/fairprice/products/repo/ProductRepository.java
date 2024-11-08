package com.fairprice.fairprice.products.repo;

import com.fairprice.fairprice.products.dto.ProductDto;
import com.fairprice.fairprice.products.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.util.List;
import java.util.UUID;

@Repository

public interface ProductRepository extends JpaRepository<Product, UUID> {

    @Query("SELECT p FROM Product p WHERE LOWER(p.name) LIKE LOWER(:query) OR p.price = :query")
    List<ProductDto> searchProducts(@Param("query") String query);
}
