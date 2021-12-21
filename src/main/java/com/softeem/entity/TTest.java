package com.softeem.entity;

import java.io.Serializable;

/**
 * (TTest)实体类
 *
 * @author panpan
 * @since 2021-10-11 21:11:35
 */
public class TTest implements Serializable {
    private static final long serialVersionUID = -96886141831359673L;

    private Integer id;

    private String name;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "TTest{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
