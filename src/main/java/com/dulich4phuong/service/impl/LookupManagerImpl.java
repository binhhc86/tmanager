package com.dulich4phuong.service.impl;

import com.dulich4phuong.dao.LookupDao;
import com.dulich4phuong.model.CustomerCategory;
import com.dulich4phuong.model.LabelValue;
import com.dulich4phuong.model.Role;
import com.dulich4phuong.service.LookupManager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


/**
 * Implementation of LookupManager interface to talk to the persistence layer.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
@Service("lookupManager")
public class LookupManagerImpl implements LookupManager {
    @Autowired
    LookupDao dao;

    /**
     * {@inheritDoc}
     */
    public List<LabelValue> getAllRoles() {
        List<Role> roles = dao.getRoles();
        List<LabelValue> list = new ArrayList<LabelValue>();

        for (Role role1 : roles) {
            list.add(new LabelValue(role1.getName(), role1.getName()));
        }

        return list;
    }

	@Override
	public List<LabelValue> getCategories() {
		List<CustomerCategory> categories = dao.getCategories();
		List<LabelValue> list = new ArrayList<LabelValue>();
		
		for (CustomerCategory cust : categories) {
			list.add(new LabelValue(cust.getCategory(), cust.getId().toString()));
		}
		return list;
	}
}
