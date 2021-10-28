package dev.techdozo.product.controller;

import dev.techdozo.product.application.Product;
import dev.techdozo.product.application.error.RecordNotFoundException;
import dev.techdozo.product.application.repository.ProductRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
public class ProductController {

  @Autowired private ProductRepository productRepository;

  @GetMapping("/products/{productId}")
  public ResponseEntity<Product> getProduct(@PathVariable String productId) {
    log.info("Fetching product {}", productId);
    var productOptional = productRepository.getProduct(productId);
    Product product = productOptional.orElseThrow(RecordNotFoundException::new);
    return new ResponseEntity<>(product, HttpStatus.OK);
  }

  @PostMapping("/products/")
  public ResponseEntity<Product> saveProduct(@RequestBody Product product) {
    log.info("Saving product");
    var savedProduct = productRepository.save(product);
    return new ResponseEntity<>(savedProduct, HttpStatus.OK);
  }
}
