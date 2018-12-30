package com.zwl.crm.domain;

public class Customer {
    private Long cust_id;
    private String cust_name;
//    private String cust_source;
//    private String cust_industry;
//    private String cust_level;
    private String cust_phone;
    private String cust_mobile;
    private String cust_prove; //客户资质证明
    private String cust_address;
    private String cust_zipcode;
    private String cust_fax;
    private String cust_email;

    /*客户和字典是多对一*/
    private BaseDict baseDictSource;
    private BaseDict baseDictIndustry;
    private BaseDict baseDictLevel;

    public BaseDict getBaseDictSource() {
        return baseDictSource;
    }

    public void setBaseDictSource(BaseDict baseDictSource) {
        this.baseDictSource = baseDictSource;
    }

    public BaseDict getBaseDictIndustry() {
        return baseDictIndustry;
    }

    public void setBaseDictIndustry(BaseDict baseDictIndustry) {
        this.baseDictIndustry = baseDictIndustry;
    }

    public BaseDict getBaseDictLevel() {
        return baseDictLevel;
    }

    public void setBaseDictLevel(BaseDict baseDictLevel) {
        this.baseDictLevel = baseDictLevel;
    }

    public Long getCust_id() {
        return cust_id;
    }

    public void setCust_id(Long cust_id) {
        this.cust_id = cust_id;
    }

    public String getCust_name() {
        return cust_name;
    }

    public void setCust_name(String cust_name) {
        this.cust_name = cust_name;
    }

    public String getCust_phone() {
        return cust_phone;
    }

    public void setCust_phone(String cust_phone) {
        this.cust_phone = cust_phone;
    }

    public String getCust_mobile() {
        return cust_mobile;
    }

    public void setCust_mobile(String cust_mobile) {
        this.cust_mobile = cust_mobile;
    }

    public String getCust_prove() {
        return cust_prove;
    }

    public void setCust_prove(String cust_prove) {
        this.cust_prove = cust_prove;
    }

    public String getCust_address() {
        return cust_address;
    }

    public void setCust_address(String cust_address) {
        this.cust_address = cust_address;
    }

    public String getCust_zipcode() {
        return cust_zipcode;
    }

    public void setCust_zipcode(String cust_zipcode) {
        this.cust_zipcode = cust_zipcode;
    }

    public String getCust_fax() {
        return cust_fax;
    }

    public void setCust_fax(String cust_fax) {
        this.cust_fax = cust_fax;
    }

    public String getCust_email() {
        return cust_email;
    }

    public void setCust_email(String cust_email) {
        this.cust_email = cust_email;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "cust_id=" + cust_id +
                ", cust_name='" + cust_name + '\'' +
                ", cust_phone='" + cust_phone + '\'' +
                ", cust_mobile='" + cust_mobile + '\'' +
                ", cust_prove='" + cust_prove + '\'' +
                ", baseDictSource=" + baseDictSource +
                ", baseDictIndustry=" + baseDictIndustry +
                ", baseDictLevel=" + baseDictLevel +
                '}';
    }
}
