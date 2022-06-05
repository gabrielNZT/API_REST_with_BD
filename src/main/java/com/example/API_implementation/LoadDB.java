package com.example.API_implementation;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class LoadDB {
    private static final Logger log = LoggerFactory.getLogger(LoadDB.class);

    @Bean
    CommandLineRunner commandLineRunner(Repository repository){
        return args -> {
            log.info("log of event save car 1: "+ repository.save(new Car("hb20", "hyundai")));
            log.info("log of event save car 2"+ repository.save(new Car("onix", "chevrolet")));
            log.info("log of event save car 3"+ repository.save(new Car("m3", "bmw")));
            log.info("log of event save car 4"+ repository.save(new Car("320i", "bmw")));
        };
    }
}
