package com.example.bookmarket.web.rest;

import com.example.bookmarket.domain.Products;
import com.example.bookmarket.domain.request.ReqProduct;
import com.example.bookmarket.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/book")
public class ProductsResource {
    private final ProductService productService;

    public ProductsResource(ProductService productService) {
        this.productService = productService;
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody ReqProduct reqProduct) {
        String config = productService.create(reqProduct);
        return ResponseEntity.ok(config);
    }

    @PostMapping("/update")
    public ResponseEntity<?> update(@RequestBody ReqProduct reqProduct) {
        String config = productService.update(reqProduct);
        return ResponseEntity.ok(config);
    }

    @GetMapping("/all")
    public ResponseEntity<?> all() {
        List<Products> all = productService.all();
        return ResponseEntity.ok(all);
    }

    @GetMapping("/byId/{id}")
    public ResponseEntity<?> byId(@PathVariable Long id) {
        Products byId = productService.byId(id);
        return ResponseEntity.ok(byId);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id) {
        productService.delete(id);
        return ResponseEntity.ok("delete");
    }
    @GetMapping("/filter")
    public ResponseEntity<?> filter(@RequestParam String type,@RequestParam String searchName) {
        List<Products> filter = productService.filter(type,searchName);
        return ResponseEntity.ok(filter);
    }

}
