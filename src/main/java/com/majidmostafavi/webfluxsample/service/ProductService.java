package com.majidmostafavi.webfluxsample.service;

import com.majidmostafavi.webfluxsample.dao.ProductDao;
import com.majidmostafavi.webfluxsample.dto.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;

import java.util.List;

@Service
public class ProductService {
    @Autowired
    ProductDao productDao;



    public List<Product> findAllProduct() {
        long start = System.currentTimeMillis();
        List<Product> products = productDao.findAllProduct();
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end-start));
        return products;
    }
    public Flux<Product> findAllProductStream() {
        long start = System.currentTimeMillis();
        Flux<Product> products = productDao.findAllProductFlux();
        long end = System.currentTimeMillis();
        System.out.println("Time: " + (end-start));
        return products;
    }
}
