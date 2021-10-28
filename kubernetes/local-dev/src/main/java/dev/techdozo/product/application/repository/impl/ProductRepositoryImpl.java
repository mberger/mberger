package dev.techdozo.product.application.repository.impl;

import dev.techdozo.product.application.Product;
import dev.techdozo.product.application.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

@Repository
@Slf4j
public class ProductRepositoryImpl implements ProductRepository {

  private final Map<String, Product> storage = new HashMap<>();

  @Override
  public Optional<Product> getProduct(String productId) {
    log.info("Finding details of product, id {}", productId);
    return Optional.ofNullable(storage.get(productId));
  }

  @Override
  public Product save(Product product) {
    log.info("Saving product {}", product);
    var uuid = UUID.randomUUID().toString();
    product.setId(uuid);
    storage.put(uuid, product);
    return product;
  }
}
