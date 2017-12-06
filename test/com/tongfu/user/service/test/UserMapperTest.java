package com.tongfu.user.service.test;


import javax.annotation.Resource;

import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;

import com.tongfu.user.entity.User;
import com.tongfu.user.service.IUserService;

//@RunWith(SpringJUnit4ClassRunner.class)  
//@Transactional 
//@TransactionConfiguration(transactionManager = "txManager")  
/**
 AbstractTransactionalJUnit4SpringContextTests:
   这个类为我们解决了在web.xml中配置OpenSessionInview所解决的session生命周期延长的问题，所以要继承这个类。
   该类已经在类级别预先配置了好了事务支持，因此不必再配置@Transactional和@RunWith
 */
@ContextConfiguration("classpath:META-INF/conf/spring/application.xml")
public class UserMapperTest extends AbstractTransactionalJUnit4SpringContextTests {
    @Resource
    IUserService userService;

    @Test
    public void testGetUser() throws Exception {
        
        User user = new User();
        user.setId("1");
        user = userService.getUser(user);
        System.out.println(user);
    }
    
    
    @Test
    //@Rollback(false) //控制回滚
    public void testUpdateUser() throws Exception {
        
        User user = new User();
        user.setId("1");
        user = userService.getUser(user);
        System.out.println(user);
        user.setName("Hello");
        userService.updateUser(user);//更新
        System.out.println( userService.getUser(user));
    }
    
    @Test
    @Rollback(false) //控制回滚
    public void testSaveUser() throws Exception {
        
        User user = new User();
        user.setAge(11);
        user.setName("Alan");
        user.setSex("0");
        System.out.println(user);
        userService.saveUser(user);//更新
    }
    
    
    @Test
    public void testDeleteUser() throws Exception {
        
        User user = new User();
        user.setId("10");
        userService.deleteUser(user);//删除
        
    }
    
    
    

}
