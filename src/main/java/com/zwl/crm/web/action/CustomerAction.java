package com.zwl.crm.web.action;

import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zwl.crm.domain.Customer;
import com.zwl.crm.service.CustomerService;

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

    public String save_UI(){
        System.out.println("方法执行了-----------");
        return "saveUI";
    }

}
