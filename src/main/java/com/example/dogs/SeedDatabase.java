package com.example.dogs;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Slf4j // Lombok autocreates Slf4j-based logs
@Configuration // Indicates that a class declares one or more @Beans
// Bean - object, method controlled by Spring. Contains java + metadata
public class SeedDatabase {

    @Bean
    // CommandLineRunner - Spring Boot Runs all Beans at startup
    public CommandLineRunner initDB(EmployeeRepository emprepos)
    {
        return args ->
        {
            log.info("Seeding " + emprepos.save(new Dogs("Springer", 50, false)));
            log.info("Seeding " + emprepos.save(new Dogs("Bulldog", 50, true)));
            log.info("Seeding " + emprepos.save(new Dogs("Collie", 50, false)));
            log.info("Seeding " + emprepos.save(new Dogs("Boston Terrie", 35, true)));
            log.info("Seeding " + emprepos.save(new Dogs("Corgie", 35, true)));
        };
    }
}
