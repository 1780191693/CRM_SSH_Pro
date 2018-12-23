package com.zwl.crm.dao.Impl;

import com.zwl.crm.dao.CustomerDao;
import com.zwl.crm.domain.Customer;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Projections;
import org.springframework.orm.hibernate5.support.HibernateDaoSupport;

import java.util.List;

public class CustomerDaoImpl extends HibernateDaoSupport implements CustomerDao {
    @Override
    public void saveCustomer(Customer customer) {
        this.getHibernateTemplate().save(customer);
    }

    @Override
    public Integer findAllCount(DetachedCriteria detachedCriteria) {
        //设置查询目标 count(*)
        //离线条件查询语句QBC
        detachedCriteria.setProjection(Projections.rowCount());
        List<Long> list = (List<Long>) this.getHibernateTemplate().findByCriteria(detachedCriteria);
        if (list.size() > 0)
            return list.get(0).intValue();
        return null;
    }

    @Override
    public List<Customer> findAllCustomer(DetachedCriteria detachedCriteria, Integer begin, Integer pageSize) {
        //清空上面设置的查询目标条件
        detachedCriteria.setProjection(null);
        return (List<Customer>) this.getHibernateTemplate().findByCriteria(detachedCriteria,begin,pageSize);
    }
}
