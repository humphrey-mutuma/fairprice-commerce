package com.fairprice.fairprice.products.services;

import com.fairprice.fairprice.exceptions.ResourceNotFoundException;
import com.fairprice.fairprice.products.dto.ProductDto;
import com.fairprice.fairprice.products.repo.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {
    private final ProductRepository productRepository;


    @Override
    public ProductDto findProductById(UUID productId) {
        productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found!"));

        return null;
    }

    @Override
    public List<ProductDto> findProducts(int page, int pageSize) {
        return List.of();
    }

    @Override
    public List<ProductDto> searchProducts(int query, int page, int pageSize) {
        return List.of();
    }

    @Override
    public String updateProduct(UUID productId, ProductDto productDto) {
        return "";
    }

    @Override
    public String deleteProduct(UUID productId) {
        productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found!"));
        productRepository.deleteById(productId);
        return "Product deleted successfully";
    }
}
