package me.enset.demobddcspringdata.web;

import me.enset.demobddcspringdata.entite.Product;
import me.enset.demobddcspringdata.repository.ProductRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api")
public class ProductRestController {
    @Autowired
    private ProductRepository productRepository;
    @GetMapping ("/products")
    public List<Product> allProducts(){
        return productRepository.findAll();
    }
    @GetMapping("/products/{id}")
    public Product findBuId(@PathVariable long id){
        return productRepository.findById(id).orElseThrow(
                ()-> new RuntimeException("Product not found"));

    }
    @GetMapping ("/find/products")
    public List<Product> findProducts(@RequestParam(name = "kw" , defaultValue ="") String kw){
        return productRepository.findByNameContains(kw);
    }
    @PostMapping("/products")
    public Product save(@RequestBody Product product){
        return productRepository.save(product);
    }
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable long id){
        productRepository.deleteById(id);
    }
}
