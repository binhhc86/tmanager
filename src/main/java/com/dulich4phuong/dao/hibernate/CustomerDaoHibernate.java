package com.dulich4phuong.dao.hibernate;

import java.util.List;

import org.hibernate.Query;
import org.springframework.stereotype.Repository;

import com.dulich4phuong.dao.CustomerDao;
import com.dulich4phuong.model.Customer;

@Repository("customerDao")
public class CustomerDaoHibernate extends GenericDaoHibernate<Customer, Long> implements CustomerDao{

	public CustomerDaoHibernate() {
		super(Customer.class);
	}

	@Override
	public Customer saveCustomer(Customer cust) {
		if (log.isDebugEnabled()) {
            log.debug("user's id: " + cust.getId());
        }
        getSession().saveOrUpdate(cust);
        // necessary to throw a DataIntegrityViolation and catch it in UserManager
        getSession().flush();
        return cust;
	}


	@Override
	public List<Customer> getCustomers() {
		Query qry = getSession().createQuery("from Customer c order by upper(c.firstname)");
        return qry.list();
	}


}
