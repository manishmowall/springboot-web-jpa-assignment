package org.webonise.springboot;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.webonise.springboot.models.Customer;
import org.webonise.springboot.repositories.CustomerRepository;

@SpringBootApplication
public class Application implements CommandLineRunner {

    @Autowired
    CustomerRepository repository;

    @Override
    public void run(String... strings) throws Exception {
        repository.save(new Customer("Nitish Mowall", "nitishmowall@gmail.com"));
        repository.save(new Customer("kuldeep Singh", "kuldeepsingh@gmail.com"));
        repository.save(new Customer("kuldeep Sharma", "kuldeepsingh@gmail.com"));
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }
}
