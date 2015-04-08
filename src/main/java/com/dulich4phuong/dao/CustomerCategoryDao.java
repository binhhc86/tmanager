package com.dulich4phuong.dao;

import com.dulich4phuong.model.CustomerCategory;

public interface CustomerCategoryDao extends GenericDao<CustomerCategory, Long>{
	public CustomerCategory getCustomerCategory(Long id);
}
