package com.baizhi.test;

import com.baizhi.service.AdminService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration("classpath:/spring.xml")
public class TestAdmin {
    @Autowired
    private AdminService adminService;
    @Test
    public void test1(){
        Object login = adminService.login("1", "1");
        System.out.println(login);
    }
}
