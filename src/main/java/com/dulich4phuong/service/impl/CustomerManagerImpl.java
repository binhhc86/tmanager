package com.dulich4phuong.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.dulich4phuong.dao.CustomerDao;
import com.dulich4phuong.model.Customer;
import com.dulich4phuong.service.CustomerManager;

@Service("customerManager")
public class CustomerManagerImpl extends GenericManagerImpl<Customer, Long> implements CustomerManager{
	CustomerDao customerDao;
	
	@Autowired
    public CustomerManagerImpl(CustomerDao customerDao) {
        super(customerDao);
        this.customerDao = customerDao;
    }
	
	@Override
	public List getCustomers() {
		return customerDao.getCustomers();
	}

	@Override
	public Customer getCustomer(Long id) {
		return customerDao.get(id);
	}

	@Override
	public Customer saveCustomer(Customer cust) {
		return customerDao.saveCustomer(cust);
	}

	@Override
	public List<Customer> search(String searchTerm) {
		return super.search(searchTerm, Customer.class);
	}

}
