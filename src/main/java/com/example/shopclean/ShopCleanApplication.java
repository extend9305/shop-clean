package com.example.shopclean;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.scheduling.annotation.EnableAsync;

@EnableAsync
@SpringBootApplication
public class ShopCleanApplication {

    public static void main(String[] args) {
        SpringApplication.run(ShopCleanApplication.class, args);
    }

}
