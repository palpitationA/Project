package com.softeem.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 部门表(Department)实体类
 *
 * @author panpan
 * @since 2021-10-15 14:17:00
 */
@Data
public class Department implements Serializable {

    private static final long serialVersionUID = -86378039951604841L;
    /**
     * 部门id
     */
    private Integer depId;
    /**
     * 部门名称
     */
    private String name;
    /**
     * 办公地点
     */
    private String address;
    /**
     * 1代表有效,0代表无效
     */
    private Integer status;

    @Override
    public String toString() {
        return "Department{" +
                "depId=" + depId +
                ", name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", status=" + status +
                '}';
    }
}
