package org.webonise.springboot.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.webonise.springboot.models.Customer;
import org.webonise.springboot.repositories.CustomerRepository;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

@RestController
@RequestMapping(value = "/customer")
public class CustomerController {

    @Autowired
    CustomerRepository repository;

    @RequestMapping(value = "/list", method = RequestMethod.GET, produces = "application/json")
    public List<Customer> getCustomers() {
        Iterator<Customer> iterator = repository.findAll().iterator();
        List<Customer> customers = new ArrayList<>();
        while (iterator.hasNext()) {
            Customer customer = iterator.next();
            customers.add(customer);
        }

        return customers;
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET, produces = "application/json")
    public Object getCustomerById(@PathVariable Long id) {
        Customer customer = repository.findById(id);
        if (customer == null) {

        }
        return customer;
    }

    @RequestMapping(value = "/add/name={name}&email={email}", method = RequestMethod.GET, produces = "application/json")
    public Customer addCustomer(@PathVariable String name, @PathVariable String email) {
        Customer customer = new Customer(name, email);
        return repository.save(customer);
    }
}
