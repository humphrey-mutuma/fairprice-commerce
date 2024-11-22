package com.fairprice.fairprice.products.services;

import com.fairprice.fairprice.exceptions.ResourceNotFoundException;
import com.fairprice.fairprice.exceptions.UnauthorizedException;
import com.fairprice.fairprice.products.dto.AllProductsDto;
import com.fairprice.fairprice.products.dto.ProductDto;
import com.fairprice.fairprice.products.model.Product;
import com.fairprice.fairprice.products.repo.ProductRepository;
import com.fairprice.fairprice.user.model.User;
import com.fairprice.fairprice.user.repo.UserRepository;
import jakarta.persistence.Column;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class ProductService implements IProductService {

    private final ProductRepository productRepository;
    private final ModelMapper modelMapper;
    private final UserRepository userRepository;



    @Override
    public ProductDto findProductById(UUID productId) {
        Product product = productRepository.findById(productId)
                .orElseThrow(() -> new ResourceNotFoundException("Product not found!"));

        return modelMapper.map(product, ProductDto.class);
    }

    @Override
    public List<AllProductsDto> findAllProducts() {

        return productRepository.findAllProducts();

    }

    @Override
    public List<ProductDto> searchProducts(String query, int page, int pageSize) {
//        Pageable pageable = PageRequest.of(page, pageSize);

        List<ProductDto> searchResults  = productRepository.searchProducts(query);

        return searchResults
                .stream()
                .limit(pageSize)
                .collect(Collectors.toList());
    }

    @Override
    public String createProduct(ProductDto productDto, UserDetails userDetails) {
         User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow(() -> new ResourceNotFoundException("Owner not found!"));

        Product newProduct = new Product();

        newProduct.setName(productDto.getName());
        newProduct.setPrice(productDto.getPrice());
        newProduct.setImage(productDto.getImage());
        newProduct.setWeight(productDto.getWeight());
        newProduct.setHalal(productDto.getIsHalal());
        newProduct.setRating(productDto.getRating());
        newProduct.setReviews(productDto.getReviews());
        newProduct.setUser(user);

        productRepository.save(newProduct);

        return "Product created successfully";
    }

    @Override
    public String updateProduct(UUID productId, ProductDto productDto, UserDetails  userDetails) {
        User user = userRepository.findByUsername(userDetails.getUsername()).orElseThrow(() -> new ResourceNotFoundException("Owner not found!"));
        Product existingProduct = productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product to update not found!"));

        // Check if the current user is the owner of the product (authorization check)
        if (!existingProduct.getUser().getId().equals(user.getId())) {
            throw new UnauthorizedException("You do not have permission to update this product.");
        }

        existingProduct.setName(productDto.getName());
        existingProduct.setPrice(productDto.getPrice());
        existingProduct.setImage(productDto.getImage());
        existingProduct.setWeight(productDto.getWeight());
        existingProduct.setHalal(productDto.getIsHalal());
        existingProduct.setRating(productDto.getRating());
        existingProduct.setReviews(productDto.getReviews());

        productRepository.save(existingProduct);

        return "Product updated successfully";
    }

    @Override
    public String deleteProduct(UUID productId) {
        productRepository.findById(productId).orElseThrow(() -> new ResourceNotFoundException("Product not found!"));
        productRepository.deleteById(productId);
        return "Product deleted successfully";
    }
}
