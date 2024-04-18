package com.example.bookmarket.service.impl;

import com.example.bookmarket.domain.Products;
import com.example.bookmarket.domain.request.ReqProduct;
import com.example.bookmarket.repository.ProductRepository;
import com.example.bookmarket.service.ProductService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    public String create(ReqProduct reqProduct) {
        try {
            Products products = new Products();
            products.setBookName(reqProduct.getBookName());
            products.setAuthor(reqProduct.getAuthor());
            products.setCover(reqProduct.getCover());
            products.setPage(reqProduct.getPage());
            products.setPublisher(reqProduct.getPublisher());
            products.setBookLanguage(reqProduct.getBookLanguage());
            products.setYear(reqProduct.getYear());
            products.setCost(reqProduct.getCost());
            productRepository.save(products);
            return "save";
        } catch (Exception e) {
            e.printStackTrace();
            return "Eror";
        }
    }

    public String update(ReqProduct reqProduct) {
        try {
            if (reqProduct.getId() != null) {
                if (productRepository.findById(reqProduct.getId()).isPresent()) {
                    Products products = productRepository.findById(reqProduct.getId()).get();
                    products.setBookName(reqProduct.getBookName());
                    products.setAuthor(reqProduct.getAuthor());
                    products.setPage(reqProduct.getPage());
                    products.setPublisher(reqProduct.getPublisher());
                    products.setBookLanguage(reqProduct.getBookLanguage());
                    products.setYear(reqProduct.getYear());
                    products.setCost(reqProduct.getCost());
                    productRepository.save(products);
                    return "save";
                } else {
                    return " kitob tanlanmadi";
                }
            } else {
                return " id topilmadi";
            }
        } catch (Exception e) {
            e.printStackTrace();
            return "Eror";
        }
    }

    public List<Products> all() {
        List<Products> products = productRepository.findAll();
        return products;
    }

    public Products byId(Long id) {
        Optional<Products> byId = productRepository.findById(id);
        return byId.orElseGet(Products::new);
    }

    public void delete(Long id) {
        Products products = productRepository.getReferenceById(id);
        productRepository.delete(products);
    }

    public List<Products> filter(String type, String searchName) {
        List<Products> products = new ArrayList<>();
        switch (type) {
            case "bookName":
                products = productRepository.findByBookName(searchName);
                break;
            case "cost":
                products = productRepository.findByCost(searchName);
                break;
            case "author":
                products = productRepository.findByAuthor(searchName);
                break;
            case "cover":
                products = productRepository.findByCover(searchName);
                break;

            default:
                System.out.println("Invalid type");
        }
        return products;
    }

}
