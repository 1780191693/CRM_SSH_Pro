package com.zwl.crm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zwl.crm.Utils.UploadUtils;
import com.zwl.crm.domain.Customer;
import com.zwl.crm.domain.PageBean;
import com.zwl.crm.service.CustomerService;
import org.apache.commons.io.FileUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;

import java.io.File;

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

    private String uploadFileName;
    private File upload;               //上传的文件本身
    private String uploadContentType; //文件类型

    public void setUploadFileName(String uploadFileName) {
        this.uploadFileName = uploadFileName;
    }

    public void setUpload(File upload) {
        this.upload = upload;
    }

    public void setUploadContentType(String uploadContentType) {
        this.uploadContentType = uploadContentType;
    }

    /*跳转到保存用户界面*/
    public String save_UI() throws Exception{
        return "saveUI";
    }

    public String saveCustomer()throws Exception{
        if (upload != null){
            //设置文件上传路径
            String path = "C:/upload";
            String uuidFileName = UploadUtils.getUuidFileName(uploadFileName);
            String path1 = UploadUtils.getPath(uuidFileName);
            File file = new File(path + path1);
            if (!file.exists()){
                file.mkdirs();
            }
            //文件上传
            File dictFile = new File(path + path1 + "/" + uuidFileName);
            FileUtils.copyFile(upload,dictFile);
            customer.setCust_prove(path + path1 + "/" + uuidFileName);
        }
        customerService.saveCustomer(customer);
        return "saveSuccess";
    }

    public String findAllCustomer() throws Exception {
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        if (customer.getCust_name() != null){
            detachedCriteria.add(Restrictions.like("cust_name","%"+customer.getCust_name()+"%"));
        }
        if (customer.getBaseDictSource() !=null && customer.getBaseDictSource().getDict_id() != null && !"".equals(customer.getBaseDictSource().getDict_id())){
            detachedCriteria.add(Restrictions.eq("baseDictSource.dict_id",customer.getBaseDictSource().getDict_id()));
        }
        if (customer.getBaseDictLevel() !=null && customer.getBaseDictLevel().getDict_id() != null && !"".equals(customer.getBaseDictLevel().getDict_id())){
            detachedCriteria.add(Restrictions.eq("baseDictLevel.dict_id",customer.getBaseDictLevel().getDict_id()));
        }
        if (customer.getBaseDictIndustry() !=null && customer.getBaseDictIndustry().getDict_id() != null && !"".equals(customer.getBaseDictIndustry().getDict_id())){
            detachedCriteria.add(Restrictions.eq("baseDictIndustry.dict_id",customer.getBaseDictIndustry().getDict_id()));
        }
        PageBean<Customer> allCustomer = customerService.findAllCustomer(detachedCriteria, currPage,pageSize);
        ActionContext.getContext().getValueStack().push(allCustomer);
        return "findAll";
    }

    public String deleteCustomer() throws Exception {
        customer = customerService.findById(customer.getCust_id());
        if (customer.getCust_prove() != null){
            File file = new File(customer.getCust_prove());
            if (file.exists()){
                file.delete();
            }
        }
        customerService.deleteCustomer(customer);
        return "success";
    }

    public String editCustomer() throws Exception {
        customer = customerService.findById(this.customer.getCust_id());
        System.out.println(customer);
        return "success";
    }

    public String customer_update() throws Exception{
        //是否选择新文件，有则删除旧的，保存新的，否则继续使用旧的
        if (upload != null){
            String cust_prove = customer.getCust_prove();
            if (cust_prove != null || !"".equals(cust_prove)){
                File file = new File(cust_prove);
                file.delete();
            }
            //上传新文件
            String path = "C:/upload";
            String uuidFileName = UploadUtils.getUuidFileName(uploadFileName);
            String path1 = UploadUtils.getPath(uuidFileName);
            String url = path+path1;
            File file = new File(url);
            if (!file.exists())
                file.mkdirs();
            File dictFile = new File(url + "/" + uuidFileName);
            FileUtils.copyFile(upload,dictFile);
            customer.setCust_prove(url+"/"+uuidFileName);
        }
        customerService.customer_update(customer);
        return SUCCESS;
    }
}
