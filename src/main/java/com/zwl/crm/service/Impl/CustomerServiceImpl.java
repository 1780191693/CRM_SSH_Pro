package com.zwl.crm.service.Impl;

import com.zwl.crm.dao.CustomerDao;
import com.zwl.crm.domain.Customer;
import com.zwl.crm.domain.PageBean;
import com.zwl.crm.service.CustomerService;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao;

    public void setCustomerDao(CustomerDao customerDao) {
        this.customerDao = customerDao;
    }

    @Override
    public void saveCustomer(Customer customer) {
        customerDao.saveCustomer(customer);
    }

    @Override
    public PageBean<Customer> findAllCustomer(DetachedCriteria detachedCriteria,Integer currPage ,Integer pageSize) {
        PageBean<Customer> pageBean = new PageBean<>();
        pageBean.setCurrPage(currPage);
        pageBean.setPageSize(pageSize);
        Integer totalCount = customerDao.findAllCount(detachedCriteria);
        pageBean.setTotalCount(totalCount);
        Double tc = totalCount.doubleValue();
        //向上取整
        Double num = Math.ceil(tc/pageSize);
        pageBean.setTotalPage(num.intValue());
        Integer begin = (currPage - 1) * pageSize;
        List<Customer> list = customerDao.findAllCustomer(detachedCriteria,begin,pageSize);
        pageBean.setList(list);
        return pageBean;
    }
}
