package com.example.bookmarket.service;

import com.example.bookmarket.domain.Products;
import com.example.bookmarket.domain.request.ReqProduct;

import java.util.List;

public interface ProductService {
    public String create(ReqProduct reqProduct);

    public String update(ReqProduct reqProduct);

    public List<Products> all();

    public Products byId(Long id);

    public void delete(Long id);
    List<Products> filter(String type, String searchName);
}
