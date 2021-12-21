package com.softeem.dto;

import com.softeem.entity.Department;
import com.softeem.entity.Position;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author panpan@softeem.com
 * @description 报销信息DTO
 * @since 2021/10/15 14:08
 */
@ApiModel(description = "用户信息DTO")
@Data
public class ExpenseDTO implements Serializable {

    private static final long serialVersionUID = 8539749863886636667L;

    /**
     * 员工id
     */
    @ApiModelProperty(value = "员工id")
    private Integer  em_id;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String cause;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "创建时间")
    private String create_time;
    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    private Integer depId;
    /**
     * 职位id
     */
    @ApiModelProperty(value = "职位id")
    private Integer positionId;
    /*
    * 报销单id
    * */
    @ApiModelProperty(value = "报销单id")
    private Integer expense_id;
    /**
     * 状态(0:离职 1:在职)
     */
    @ApiModelProperty(value = "状态(0:离职 1:在职)")
    private Integer status;

    /*
    *
    * */
    @ApiModelProperty(value = "报销金额")
    private Integer total_amount;

    /*
     *
     * */
    @ApiModelProperty(value = "待处理人")
    private String next_deal_em;

    /**
     * 关联的部门信息
     */
    @ApiModelProperty(value = "关联的部门信息")
    private Department department;

    /**
     * 关联的职位信息
     */
    @ApiModelProperty(value = "关联的职位信息")
    private Position position;












}
