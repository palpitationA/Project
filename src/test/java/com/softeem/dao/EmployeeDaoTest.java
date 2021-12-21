package com.softeem.dao;

import com.softeem.dto.EmployeeDTO;
import com.softeem.entity.Employee;
import com.softeem.util.MD5Util;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration:是Spring-test提供的确定配置文件的地址
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
//@WebAppConfiguration:是Spring-test提供的确定web开发环境的资源路径
@WebAppConfiguration
public class EmployeeDaoTest {

    @Autowired
    private EmployeeDao employeeDao;

    @Test
    public void queryEmInfoByUsernameAndPassword() {
        EmployeeDTO employeeDTO = employeeDao.queryEmInfoByUsernameAndPassword("13100000001", "123456");
        System.out.println(employeeDTO);
    }

    @Test
    public void insertEmployee(){
        for (int i = 0; i < 17; i++) {
            Employee employee = new Employee();
            employee.setName("测试员工"+i);
            employee.setPassword(MD5Util.getMD5("123456"));
            employee.setStatus(1);
            employee.setDepId(1);
            employee.setLoginName("1310000000"+(i+3));
            employee.setPositionId(1);
            employeeDao.insert(employee);
        }
    }
}