package com.dulich4phuong.dao;

import com.dulich4phuong.model.Customer;
import com.dulich4phuong.model.CustomerCategory;
import com.dulich4phuong.model.Role;

import java.util.List;

/**
 * Lookup Data Access Object (GenericDao) interface.  This is used to lookup values in
 * the database (i.e. for drop-downs).
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 */
public interface LookupDao {
    //~ Methods ================================================================

    /**
     * Returns all Roles ordered by name
     * @return populated list of roles
     */
    List<Role> getRoles();
    
    List<CustomerCategory> getCategories();
    
}
