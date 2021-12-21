package com.softeem.service.impl;

import com.softeem.entity.Department;
import com.softeem.service.DepartmentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.util.Map;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration:是Spring-test提供的确定配置文件的地址
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
//@WebAppConfiguration:是Spring-test提供的确定web开发环境的资源路径
@WebAppConfiguration
public class DepartmentServiceImplTest {

    @Autowired
    private DepartmentService departmentService;

    @Test
    public void queryByPageList() {
//        Map<String, Object> map = departmentService.queryByPageList();
//        System.out.println(map);
    }
    @Test
    public void insertDepartment(){
        for (int i = 0; i < 10; i++) {
            Department department = new Department();
            department.setName("测试部"+i);
            department.setAddress("湖北省武汉市光谷智慧园16栋");
            department.setStatus(1);
            departmentService.insert(department);
        }


    }
}