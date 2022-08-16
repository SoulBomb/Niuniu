package com.example.land;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
//@NacosPropertySource(dataId = "example", autoRefreshed = true)
public class LandApplication {

    public static void main(String[] args) {
        SpringApplication.run(LandApplication.class, args);
    }

}
