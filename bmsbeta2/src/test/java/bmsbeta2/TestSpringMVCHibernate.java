package bmsbeta2;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import zhao.blog.managementsystem.entity.Manager;
import zhao.blog.managementsystem.service.ManagerService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration(locations = { "classpath:spring.xml",  
        "classpath:spring-hibernate.xml" })  
public class TestSpringMVCHibernate {    
    @Autowired  
    private ManagerService managerServiceImpl;  
  
    @Test  
    public void save() {  
        Manager acctUser = new Manager();  
        acctUser.setAccount("AAAAAA");
        acctUser.setPassword("SSSSSS");
        managerServiceImpl.save(acctUser);  
    }  
  
}  
