package com.zwl.crm.service.Impl;

import com.zwl.crm.dao.CustomerDao;
import com.zwl.crm.service.CustomerService;

public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }
}
