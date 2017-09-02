package com.nelkenstudios.usermanager;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public final class Application {

    private Application() {

    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

}
