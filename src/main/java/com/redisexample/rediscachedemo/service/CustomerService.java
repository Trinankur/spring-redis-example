package com.redisexample.rediscachedemo.service;

import com.redisexample.rediscachedemo.entity.Customer;

public interface CustomerService {

    public Customer getCustomerById(String id);
    public Customer updateCustomer(Customer customer);
    public String deleteCustomer(String id);

}
