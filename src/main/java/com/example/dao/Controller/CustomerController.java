package com.example.dao.Controller;

import com.example.dao.Repository.CustomerRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class CustomerController {
    @GetMapping("/products/fetch-product")
    private String fetchProduct(@RequestParam String name) throws SQLException {
        CustomerRepository customerRepository = new CustomerRepository();
        return customerRepository.getProductName("alexey").toString();
    }
}
