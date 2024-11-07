package com.fairprice.fairprice.products.services;


import com.fairprice.fairprice.products.dto.ProductDto;

import java.util.List;
import java.util.UUID;

public interface IProductService {

    ProductDto findProductById(UUID productId );

    List<ProductDto>  findProducts(
            int  page,
            int  pageSize
    );

     List<ProductDto> searchProducts(
            int query,
            int page,
            int pageSize
    );

    String updateProduct(
             UUID productId,
             ProductDto productDto
    );

     String deleteProduct(UUID productId );

}
