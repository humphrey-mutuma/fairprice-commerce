package com.fairprice.fairprice.products;

import com.fairprice.fairprice.products.dto.ProductDto;
import com.fairprice.fairprice.products.dto.UpdateProductDto;
import com.fairprice.fairprice.products.services.ProductService;
import com.fairprice.fairprice.reponse.ApiResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;


@RequiredArgsConstructor
@RestController
@RequestMapping("${api.prefix}/products")
public class ProductController {
    private final ProductService productService;


    //     fetch product ***********************
    @GetMapping("/{productId}")
    public ResponseEntity<ApiResponse<ProductDto>> findProductById(@PathVariable UUID productId ) {
        return ResponseEntity
                .ok(new ApiResponse<>("success" ,productService.findProductById(productId)));
    }

    //     fetch all product ***********************
    @GetMapping("/")
    public ResponseEntity<ApiResponse<List<ProductDto>>> findProducts(
            @RequestParam int page,
            @RequestParam int pageSize
    ) {
        return ResponseEntity
                .ok(new ApiResponse<>("success" ,productService.findProducts(page, pageSize)));
    }

    //     fetch all product ***********************
    @GetMapping("search/")
    public ResponseEntity<ApiResponse<List<ProductDto>>> searchProducts(
            @RequestParam int query,
            @RequestParam int page,
            @RequestParam int pageSize
    ) {
        return ResponseEntity
                .ok(new ApiResponse<>("success" ,productService.searchProducts(query,page, pageSize)));
    }

    // update product **************************
    @PatchMapping("/{productId}")
    public ResponseEntity<ApiResponse<String>> updateProduct(
            @PathVariable("productId") UUID productId,
            @RequestBody() UpdateProductDto updateProductDto
    ) {
        return ResponseEntity
                .ok(new ApiResponse<>(productService.updateProduct(productId, updateProductDto), null));
    }

    // delete product *******************
    @DeleteMapping("/{productId}")
    public ResponseEntity<ApiResponse<String>> deleteProduct(
            @PathVariable("productId") UUID productId
             )  {
        return ResponseEntity
                .ok(new ApiResponse<>( productService.deleteProduct(productId), null));
    }

}
