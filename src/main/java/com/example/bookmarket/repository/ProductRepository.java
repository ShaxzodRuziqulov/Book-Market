package com.example.bookmarket.repository;

import com.example.bookmarket.domain.Products;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Products,Long> {
//    @Query("select p from Products p where p.bookName= :bookName")
    List<Products> findByBookName(String bookName);
    List<Products> findByCost(String cost);
    List<Products> findByAuthor(String author);
    List<Products> findByCover(String cover);

}
