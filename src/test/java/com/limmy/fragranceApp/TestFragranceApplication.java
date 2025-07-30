package com.limmy.fragranceApp;

import org.springframework.boot.SpringApplication;

public class TestFragranceApplication {

    public static void main(String[] args) {
        SpringApplication.from(FragranceApplication::main).with(TestcontainersConfiguration.class).run(args);
    }

}
