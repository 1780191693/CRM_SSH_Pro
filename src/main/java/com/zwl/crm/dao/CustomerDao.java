package com.zwl.crm.dao;

import com.zwl.crm.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;

import java.util.List;

public interface CustomerDao {
    void saveCustomer(Customer customer);

    Integer findAllCount(DetachedCriteria detachedCriteria);

    List<Customer> findAllCustomer(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize);
}
