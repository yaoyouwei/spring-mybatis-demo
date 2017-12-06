package com.tongfu.user.service.test;


import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.transaction.AfterTransaction;
import org.springframework.test.context.transaction.BeforeTransaction;

import com.tongfu.user.entity.User;
import com.tongfu.user.service.IUserService;
/**
 * 继承了TongfuTransaction的注解
 * 测试事务回滚
 */
public class TongfuTransactionTest extends TongfuTransaction{
    @Resource
    IUserService userService;
    private static final String ID ="1";
    private static final String BEFORE_NAME = "Hello";
    private static final String AFTER_NAME = "World";
    
    @BeforeTransaction  
    public void beforeTransaction() {  
        String msg = "事务前用户姓名为"+BEFORE_NAME;
        this.assertUser(ID, msg,BEFORE_NAME);
        
    }  
    
    @Test
    //@Rollback(false)
    public void testUpdateUser() throws Exception {
        User user = new User();
        user.setId(ID);
        user.setName(AFTER_NAME);
        userService.updateUser(user);//更新
        user = userService.getUser(user);
        String msg = "修改后用户姓名为:"+AFTER_NAME;
        this.assertUser(ID, msg,AFTER_NAME);
    }
    
    @AfterTransaction  
    public void afterTransaction() {  
      String msg = "事务后用户姓名为:"+BEFORE_NAME;
      this.assertUser(ID, msg,BEFORE_NAME);
    }
    
    /**
     * 给定ID从数据库查出User,并与expected比较
     */
    public void assertUser(String ID,String msg,String expected){
        User user = new User();
        user.setId(ID);
        user = userService.getUser(user);
        Assert.assertEquals(msg , expected, user.getName());
    }
}
