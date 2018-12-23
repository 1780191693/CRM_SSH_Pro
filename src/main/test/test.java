import com.zwl.crm.domain.Customer;
import com.zwl.crm.domain.PageBean;
import com.zwl.crm.service.CustomerService;
import com.zwl.crm.service.Impl.CustomerServiceImpl;
import org.hibernate.criterion.DetachedCriteria;
import org.junit.Test;

public class test {

    @Test
    public void test1(){
        CustomerService service = new CustomerServiceImpl();
        DetachedCriteria detachedCriteria = DetachedCriteria.forClass(Customer.class);
        PageBean<Customer> allCustomer = service.findAllCustomer(detachedCriteria, 2, 10);
        System.out.println(allCustomer);
    }
}
