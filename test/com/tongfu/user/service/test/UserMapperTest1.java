package com.tongfu.user.service.test;


import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.tongfu.user.entity.User;
import com.tongfu.user.service.IUserService;

@RunWith(SpringJUnit4ClassRunner.class)  
@ContextConfiguration("classpath:META-INF/conf/spring/application.xml")
@Transactional
//@TransactionConfiguration(transactionManager = "txManager")  
public class UserMapperTest1{//该类未继承任何类
    @Resource
    IUserService userService;

    
    
    @Test
    //@Rollback(false)
    public void testUpdateUser() throws Exception {
        User user = new User();
        user.setId("1");
        user = userService.getUser(user);
        System.out.println(user);
        user.setName("World");
        userService.updateUser(user);//更新
        System.out.println( userService.getUser(user));
    }
    
    @Test
    public void testGetUser() throws Exception {
        
        User user = new User();
        user.setId("1");
        user = userService.getUser(user);
        System.out.println(user);
    }
    
    @Test
    public void testSaveUser() throws Exception {
        
        User user = new User();
        user.setId("6");
        user = userService.getUser(user);
        user.setId(null);
        System.out.println(user);
        userService.saveUser(user);//更新
        
    }
    
    @Test
    @Transactional
    public void testDeleteUser() throws Exception {
        
        User user = new User();
        user.setId("6");
        userService.deleteUser(user);//删除
        userService.getUser(user);
        System.out.println(user);
        
    }

}
