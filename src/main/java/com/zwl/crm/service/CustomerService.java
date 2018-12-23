package com.zwl.crm.service;

import com.zwl.crm.domain.Customer;
import com.zwl.crm.domain.PageBean;
import org.hibernate.criterion.DetachedCriteria;

public interface CustomerService {
    void saveCustomer(Customer customer);

    PageBean<Customer> findAllCustomer(DetachedCriteria detachedCriteria, Integer currPage, Integer pageSize);
}
