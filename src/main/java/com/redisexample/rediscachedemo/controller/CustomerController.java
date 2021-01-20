package com.redisexample.rediscachedemo.controller;

import com.redisexample.rediscachedemo.entity.Customer;
import com.redisexample.rediscachedemo.service.CustomerService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

@RestController
@RequestMapping("/customers")
public class CustomerController {

    @Resource
    private CustomerService customerService;

    @GetMapping("customer/{id}")
    public Customer getCustomer(@PathVariable String id) {
        return customerService.getCustomerById(id);
    }

    @PutMapping("customer")
    public Customer updateCustomer(@RequestBody Customer customer) {
        return customerService.updateCustomer(customer);
    }

    @DeleteMapping("customer/{id}")
    public String deleteCustomer(@PathVariable String id) {
        return customerService.deleteCustomer(id);
    }

}
