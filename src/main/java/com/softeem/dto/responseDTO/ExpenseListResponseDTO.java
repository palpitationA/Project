package com.softeem.dto.responseDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author panpan@softeem.com
 * @description
 * @since 2021/10/18 21:32
 */
@ApiModel(description = "部门列表ResponseDTO")
@Data
public class ExpenseListResponseDTO implements Serializable {


    private static final long serialVersionUID = -8166104945620721495L;
    private Integer expenseId;
    private String cause;
    private Integer emId;
    private String createTime;
    private Integer nextDealEm;
    private Double totalAmount;
    /**
     * 1代表有效,0代表无效
     */
    @ApiModelProperty(value = "1代表有效,0代表无效")
    private Integer status;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    @Override
    public String toString() {
        return "ExpenseListResponseDTO{" +
                "expenseId=" + expenseId +
                ", cause='" + cause + '\'' +
                ", emId=" + emId +
                ", createTime='" + createTime + '\'' +
                ", nextDealEm=" + nextDealEm +
                ", totalAmount=" + totalAmount +
                ", status=" + status +
                '}';
    }

    public Integer getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(Integer expenseId) {
        this.expenseId = expenseId;
    }

    public String getCause() {
        return cause;
    }

    public void setCause(String cause) {
        this.cause = cause;
    }

    public Integer getEmId() {
        return emId;
    }

    public void setEmId(Integer emId) {
        this.emId = emId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public Integer getNextDealEm() {
        return nextDealEm;
    }

    public void setNextDealEm(Integer nextDealEm) {
        this.nextDealEm = nextDealEm;
    }

    public Double getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(Double totalAmount) {
        this.totalAmount = totalAmount;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
