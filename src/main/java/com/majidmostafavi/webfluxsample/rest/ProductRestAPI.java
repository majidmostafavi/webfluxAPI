package com.majidmostafavi.webfluxsample.rest;

import com.majidmostafavi.webfluxsample.dto.Product;
import com.majidmostafavi.webfluxsample.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;

import java.util.List;

@RestController
@RequestMapping("products")
public class ProductRestAPI {

    @Autowired
    ProductService productService;

    @GetMapping("/getAll")
    public List<Product> getAllProduct(){
        return productService.findAllProduct();
    }
    @GetMapping(value = "/getStream",produces = MediaType.TEXT_EVENT_STREAM_VALUE)
    public Flux<Product> getAllProductStream(){
        return productService.findAllProductStream();
    }
}
