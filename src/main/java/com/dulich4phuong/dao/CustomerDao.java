package com.dulich4phuong.dao;

import java.util.List;

import com.dulich4phuong.model.Customer;

public interface CustomerDao extends GenericDao<Customer, Long> {
	Customer saveCustomer(Customer cust);

    List<Customer> getCustomers();
}
