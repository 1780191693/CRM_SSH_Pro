package com.zwl.crm.web.action;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.zwl.crm.Utils.UploadUtils;
import com.zwl.crm.domain.Customer;
import com.zwl.crm.domain.PageBean;
import com.zwl.crm.service.CustomerService;
import org.apache.commons.fileupload.FileUpload;
import org.apache.commons.io.FileUtils;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.util.FileCopyUtils;

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
        }
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
