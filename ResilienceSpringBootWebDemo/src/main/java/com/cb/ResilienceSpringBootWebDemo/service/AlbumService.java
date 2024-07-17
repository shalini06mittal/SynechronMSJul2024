package com.cb.ResilienceSpringBootWebDemo.service;


import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.circuitbreaker.CircuitBreakerFactory;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.nio.file.Files;
import java.nio.file.Paths;

@Service
public class AlbumService {

    private static final Logger LOGGER = LoggerFactory.getLogger(AlbumService.class);

   // @Autowired
    private CircuitBreakerFactory circuitBreakerFactory;

//    public AlbumService(CircuitBreakerFactory circuitBreakerFactory) {
//        this.circuitBreakerFactory = circuitBreakerFactory;
//        circuitBreakerFactory.create("circuitbreaker");
//    }

    private RestTemplate restTemplate = new RestTemplate();


//    public String getAlbumList() {
//        CircuitBreaker circuitBreaker = circuitBreakerFactory.create("circuitbreaker");
//        String url = "https://jsonplaceholder.typicode.com/albums";
//        return circuitBreaker.run(() -> restTemplate.getForObject(url, String.class),
//                throwable -> getDefaultAlbumList());
//    }

    @CircuitBreaker(name = "circuitbreaker", fallbackMethod = "getDefaultAlbumList")
    public String getAlbumList() {
        String url = "https://jsonplaceholder.typicode.com/albums";
        return  restTemplate.getForObject(url, String.class);
    }

    private String getDefaultAlbumList(Exception ex) {
        try {
            return new String(Files.readAllBytes(Paths.get(getClass().getClassLoader().getResource("fallback-album-list.json").toURI())));
        } catch (Exception e) {
            LOGGER.error("error occurred while reading the file", e);
        }
        return null;
    }

}
