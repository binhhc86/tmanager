package com.dulich4phuong.dao.hibernate;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import com.dulich4phuong.dao.LookupDao;
import com.dulich4phuong.model.Customer;
import com.dulich4phuong.model.CustomerCategory;
import com.dulich4phuong.model.Role;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

import org.hibernate.Session;

/**
 * Hibernate implementation of LookupDao.
 *
 * @author <a href="mailto:matt@raibledesigns.com">Matt Raible</a>
 *      Modified by jgarcia: updated to hibernate 4
 */
@Repository
public class LookupDaoHibernate implements LookupDao {
    private Log log = LogFactory.getLog(LookupDaoHibernate.class);
    private final SessionFactory sessionFactory;

    /**
     * Initialize LookupDaoHibernate with Hibernate SessionFactory.
     * @param sessionFactory
     */
    @Autowired
    public LookupDaoHibernate(final SessionFactory sessionFactory) {
        this.sessionFactory = sessionFactory;
    }

    /**
     * {@inheritDoc}
     */
    @SuppressWarnings("unchecked")
    public List<Role> getRoles() {
        log.debug("Retrieving all role names...");
        Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(Role.class).list();
    }

	@Override
	public List<CustomerCategory> getCategories() {
		log.debug("Retrieving all customer categories...");
		Session session = sessionFactory.getCurrentSession();
        return session.createCriteria(CustomerCategory.class).list();
	}

}
