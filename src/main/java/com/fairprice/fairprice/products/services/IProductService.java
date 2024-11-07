package com.fairprice.fairprice.products.services;


import com.fairprice.fairprice.products.dto.ProductDto;
import com.fairprice.fairprice.products.dto.UpdateProductDto;
import com.fairprice.fairprice.reponse.ApiResponse;
import com.fairprice.fairprice.user.dto.UpdateUserDto;
import com.fairprice.fairprice.user.dto.UserProfileResDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

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
             UpdateProductDto updateProductDto
    );

     String deleteProduct(UUID productId );

}
