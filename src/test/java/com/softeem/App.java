package com.softeem;

import com.softeem.dao.TTestDao;
import com.softeem.entity.TTest;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

/**
 * @author muzi@softeem.com
 * @description
 * @since 2021/5/11 21:09
 */
//@RunWith:Junit提供的,让我们确定运行环境
@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration:是Spring-test提供的确定配置文件的地址
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
//@WebAppConfiguration:是Spring-test提供的确定web开发环境的资源路径
@WebAppConfiguration
public class App {

    @Autowired
    private TTestDao testDao;

    @Test
    public void testQueryById(){
        TTest tTest = testDao.queryById(1);
        System.out.println(tTest);
    }
}
