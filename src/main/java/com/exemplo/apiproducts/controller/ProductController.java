package com.exemplo.apiproducts.controller;

import com.exemplo.apiproducts.model.Product;
import com.exemplo.apiproducts.repository.ProductRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/products")
public class ProductController {

    private final ProductRepository productRepository;

    public ProductController(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @PostMapping
    public Product createProduct(@RequestBody Product product) {

        var id = UUID.randomUUID().toString();
        product.setId(id);
        Product createdProduct = productRepository.save(product);
        System.out.printf("\nProduto criado: %s (ID: %s)\n",
                createdProduct.getName(),
                createdProduct.getId());
        return product;
    }

    @GetMapping("/{id}")
    public Product getProductById(@PathVariable("id") String id) {
        Product productId = productRepository.findById(id).orElse(null);
        System.out.printf("\nProduto encontrado: %s (ID: %s)\n",
                productId.getName(),
                productId.getId());
        return productRepository.findById(id).orElse(null);
    }

    @DeleteMapping("/{id}")
    public void deleteProduct(@PathVariable("id") String id) {
        Product productId = productRepository.findById(id).orElse(null);
        System.out.printf("\nProduto deletado: %s (ID: %s)\n",
                productId.getName(),
                productId.getId());
        productRepository.deleteById(id);
    }

    @PutMapping("/{id}")
    public void updateProduct(@PathVariable("id") String id,
                              @RequestBody Product product) {
        Product productId = productRepository.findById(id).orElse(null);
        product.setId(id);
        productRepository.save(product);
        System.out.printf("\nProduto Atualizado: %s (ID: %s)\n",
                productId.getName(),
                productId.getId());
    }

    @GetMapping
    public List<Product> searchByName(@RequestParam("name") String name) {
        List<Product> products = productRepository.findByName(name);
        System.out.printf("\nProdutos encontrados com o nome '%s':\n", name);
        products.forEach(product ->
                System.out.printf("   - %s (ID: %s, Preço: R$%.2f)\n",
                        product.getName(),
                        product.getId(),
                        product.getPrice()));
        return productRepository.findByName(name);
    }
}