package com.softeem.dto.requestDTO;


import com.softeem.dto.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * VO(View Object)
 * @author panpan@softeem.com
 * @description
 * @since 2021/10/20 21:19
 */
@ApiModel(description = "获取报销单列表RequestDTO")
@Data
public class ExpensetListReqeustDTO extends PageDTO implements Serializable {

    private static final long serialVersionUID = 8123672196062695732L;

//    @ApiModelProperty(value = "报销单名称关键字",example = "")
//    private String name;
//    @ApiModelProperty(value = "报销单地址关键字",example = "")
//    private String cause;
//    @ApiModelProperty(value = "状态",example = "")
//    private Integer status;
//
//    public static long getSerialVersionUID() {
//        return serialVersionUID;
//    }
//
//    public String getName() {
//        return name;
//    }
//
//    public void setName(String name) {
//        this.name = name;
//    }
//
//    public String getCause() {
//        return cause;
//    }
//
//    public void setCause(String cause) {
//        this.cause = cause;
//    }
//
//    public Integer getStatus() {
//        return status;
//    }
//
//    public void setStatus(Integer status) {
//        this.status = status;
//    }

    private int expenseId;

    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    public int getExpenseId() {
        return expenseId;
    }

    public void setExpenseId(int expenseId) {
        this.expenseId = expenseId;
    }
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

    @Override
    public String toString() {
        return "ExpensetListReqeustDTO{" +
                "expenseId=" + expenseId +
                ", cause='" + cause + '\'' +
                ", emId=" + emId +
                ", createTime='" + createTime + '\'' +
                ", nextDealEm=" + nextDealEm +
                ", totalAmount=" + totalAmount +
                ", status=" + status +
                '}';
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
