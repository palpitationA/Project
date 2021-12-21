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
public class DepartmentListResponseDTO implements Serializable {


    private static final long serialVersionUID = 2180640173556428777L;

    /**
     * 部门id
     */
    @ApiModelProperty(value = "部门id")
    private Integer depId;
    /**
     * 部门名称
     */
    @ApiModelProperty(value = "部门名称")
    private String name;
    /**
     * 办公地点
     */
    @ApiModelProperty(value = "办公地点")
    private String address;
    /**
     * 1代表有效,0代表无效
     */
    @ApiModelProperty(value = "1代表有效,0代表无效")
    private Integer status;



}
