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
public class Expense implements Serializable {

    private static final long serialVersionUID = -86378039951604841L;
    /**
     * 1代表有效,0代表无效
     */
    private Integer status;
    /**
     * 报销单id
     */
    private String expenseId;
    /**
     * 报销详情
     */
    private String cause;
    /**
     * 创建人id
     */
    private String emId;
    /**
     * 申请时间
     */
    private String createTime;
    /**
     * 待处理人
     */
    private String nextDealEm;
    /**
     * 总金额
     */
    private String totalAmount;



    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(String expenseId) {
        this.expenseId = expenseId;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public String getEmId() {
        return emId;
    }

    public void setEmId(String emId) {
        this.emId = emId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getNextDealEm() {
        return nextDealEm;
    }

    public void setNextDealEm(String nextDealEm) {
        this.nextDealEm = nextDealEm;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }



}
