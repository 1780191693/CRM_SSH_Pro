package com.zwl.crm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zwl.crm.domain.Customer;
import com.zwl.crm.domain.PageBean;
import com.zwl.crm.service.CustomerService;
import org.hibernate.criterion.DetachedCriteria;

public class CustomerAction extends ActionSupport implements ModelDriven<Customer> {

    private Customer customer = new Customer();
    @Override
    public Customer getModel() {
        return customer;
    }

    private CustomerService customerService;
    public void setCustomerService(CustomerService customerService) {
        this.customerService = customerService;
    }

    private Integer currPage = 1;
    public void setCurrPage(Integer currPage) {
        if (currPage == null)
            currPage = 1;
        this.currPage = currPage;
    }

    private Integer pageSize = 10;
    public void setPageSize(Integer pageSize) {
        if (pageSize == null)
            pageSize = 10;
        this.pageSize = pageSize;
    }

    /*跳转到保存用户界面*/
    public String save_UI() throws Exception{
        return "saveUI";
    }

    public String saveCustomer()throws Exception{
        customerService.saveCustomer(customer);
        return NONE;
    }

    public String findAllCustomer() throws Exception {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        System.out.println("currPage = " + currPage);
        System.out.println("pageSize = " + pageSize);
        PageBean<Customer> allCustomer = customerService.findAllCustomer(detachedCriteria, currPage,pageSize);
        ActionContext.getContext().getValueStack().push(allCustomer);
        return "findAll";
    }

}
