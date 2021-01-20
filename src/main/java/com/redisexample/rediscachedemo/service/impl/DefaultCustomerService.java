package com.redisexample.rediscachedemo.service.impl;

import com.redisexample.rediscachedemo.entity.Customer;
import com.redisexample.rediscachedemo.service.CustomerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.CacheConfig;
import org.springframework.cache.annotation.CacheEvict;
import org.springframework.cache.annotation.CachePut;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@Service
@CacheConfig(cacheNames = {"Customer"})
public class DefaultCustomerService implements CustomerService {

    private static final Logger LOG = LoggerFactory.getLogger(DefaultCustomerService.class);

    @Override
    @Cacheable(key = "#id")
    public Customer getCustomerById(String id) {
        LOG.info("Getting customer information for id {} ", id);
        return new Customer("User"+id, "contact-us@journaldev", id);
    }

    @Override
    @CachePut(key = "#customer.getId()")
    public Customer updateCustomer(Customer customer) {
        LOG.info("Customer with id {} updated.", customer.getId());
        return customer;
    }

    @Override
    @CacheEvict(key = "#id")
    public String deleteCustomer(String id) {
        LOG.info("Customer with id {} deleted.", id);
        return "Deleted + " + id;
    }


}
