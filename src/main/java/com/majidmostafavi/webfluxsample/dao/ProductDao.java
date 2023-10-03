package com.majidmostafavi.webfluxsample.dao;

import com.majidmostafavi.webfluxsample.dto.Product;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Flux;

import java.time.Duration;
import java.util.List;
import java.util.stream.Collectors;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

@Component
public class ProductDao {

    private static void sleepExecution(Integer l) {
        try {
            Thread.sleep(l*1000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
    public List<Product> findAllProduct() {
        return IntStream.rangeClosed(1, 10)
                .peek(ProductDao::sleepExecution)
                .peek(i-> System.out.println("Produce count : " + i))
                .mapToObj(
                        i -> new Product(i, "name" + i, "code" + i)
                ).collect(Collectors.toList());
    }

    public Flux<Product> findAllProductFlux() {
        return Flux.range(1,10)
                .delayElements(Duration.ofSeconds(1))
                .doOnNext(i-> System.out.println("Produce  count : " + i))
                .map(i -> new Product(i, "name" + i, "code" + i));
    }

}
