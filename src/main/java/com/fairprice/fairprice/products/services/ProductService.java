package com.fairprice.fairprice.products.services;

import com.fairprice.fairprice.products.dto.ProductDto;
import com.fairprice.fairprice.products.dto.UpdateProductDto;
import com.fairprice.fairprice.user.dto.UpdateUserDto;
import com.fairprice.fairprice.user.dto.UserProfileResDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {


    @Override
    public ProductDto findProductById(UUID productId) {
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
    public String updateProduct(UUID productId, UpdateProductDto updateProductDto) {
        return "";
    }

    @Override
    public String deleteProduct(UUID productId) {
        return "";
    }
}
