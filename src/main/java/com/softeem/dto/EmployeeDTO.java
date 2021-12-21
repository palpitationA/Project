package com.softeem.dto;

import com.softeem.entity.Department;
import com.softeem.entity.Position;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author panpan@softeem.com
 * @description 员工信息DTO
 * @since 2021/10/15 14:08
 */
@ApiModel(description = "用户信息DTO")
@Data
public class EmployeeDTO implements Serializable {

    private static final long serialVersionUID = 8539749863886636667L;

    /**
     * 员工id
     */
    @ApiModelProperty(value = "员工id")
    private Integer emId;
    /**
     * 姓名
     */
    @ApiModelProperty(value = "姓名")
    private String name;
    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名")
    private String loginName;
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
    /**
     * 状态(0:离职 1:在职)
     */
    @ApiModelProperty(value = "状态(0:离职 1:在职)")
    private Integer status;

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
