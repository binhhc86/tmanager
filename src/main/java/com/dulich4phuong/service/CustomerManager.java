package com.dulich4phuong.service;

import java.util.List;

import com.dulich4phuong.model.Customer;

public interface CustomerManager extends GenericManager<Customer, Long> {
	/**
     * {@inheritDoc}
     */
    List<Customer> getCustomers();
    
    List<Customer> search(String searchTerm);

    /**
     * {@inheritDoc}
     */
    Customer getCustomer(Long id);

    /**
     * {@inheritDoc}
     */
    Customer saveCustomer(Customer cust);

    /**
     * {@inheritDoc}
     */
    //void removeRole(String rolename);
}
