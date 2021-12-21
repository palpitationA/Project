package com.softeem.entity;

import lombok.Data;

import java.io.Serializable;

/**
 * 员工表(Employee)实体类
 *
 * @author panpan
 * @since 2021-10-15 14:02:57
 */
@Data
public class Employee implements Serializable {
    private static final long serialVersionUID = 567994181421012284L;
        /**
         * 员工id
         */
        private Integer emId;
        /**
         * 密码
         */
        private String password;
        /**
         * 姓名
         */
        private String name;
        /**
         * 用户名
         */
        private String loginName;
        /**
         * 部门id
         */
        private Integer depId;
        /**
         * 职位id
         */
        private Integer positionId;
        /**
         * 状态(0:离职 1:在职)
         */
        private Integer status;


    public Integer getEmId() {
        return emId;
    }

    public void setEmId(Integer emId) {
        this.emId = emId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLoginName() {
        return loginName;
    }

    public void setLoginName(String loginName) {
        this.loginName = loginName;
    }

    public Integer getDepId() {
        return depId;
    }

    public void setDepId(Integer depId) {
        this.depId = depId;
    }

    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
