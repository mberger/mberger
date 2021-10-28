package dev.techdozo.product.application.repository;

import dev.techdozo.product.application.Product;

import java.util.Optional;

public interface ProductRepository {

    /**
     * Get Product by ID
     * @param productId Product Id
     * @return product
     */
    Optional<Product> getProduct(String productId);

    /**
     * Save product
     * @param product product to be saved
     * @return Saved product
     */
    Product save(Product product);
}
