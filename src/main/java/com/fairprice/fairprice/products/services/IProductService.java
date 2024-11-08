package com.fairprice.fairprice.products.services;


import com.fairprice.fairprice.products.dto.ProductDto;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.List;
import java.util.UUID;

public interface IProductService {

    ProductDto findProductById(UUID productId );

    List<ProductDto>  findProducts(
            int  page,
            int  pageSize
    );

     List<ProductDto> searchProducts(
            String query,
            int page,
            int pageSize
    );

    String createProduct( ProductDto productDto, UserDetails userDetails);

    String updateProduct(
            UUID productId,
            ProductDto productDto,
            UserDetails userDetails
    );

     String deleteProduct(UUID productId );

}
