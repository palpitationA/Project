package com.softeem.dao;

import com.softeem.entity.Position;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import java.time.LocalDate;
import java.util.Date;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration:是Spring-test提供的确定配置文件的地址
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
//@WebAppConfiguration:是Spring-test提供的确定web开发环境的资源路径
@WebAppConfiguration
public class PositionDaoTest {


    @Autowired
    private PositionDao positionDao;

    @Test
    public void insert() {
        for (int i = 0; i < 13; i++) {
            Position position = new Position();
            position.setPositionName("测试职位"+i);
            position.setCreateTime(new Date());
            position.setStatus(1);
            positionDao.insert(position);
        }
    }
}