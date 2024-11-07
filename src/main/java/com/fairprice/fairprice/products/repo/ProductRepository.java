package com.fairprice.fairprice.products.repo;

import com.fairprice.fairprice.products.model.Product;
import com.fairprice.fairprice.user.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
import java.util.UUID;

@Repository
public interface ProductRepository extends JpaRepository<Product, UUID> {

 }
