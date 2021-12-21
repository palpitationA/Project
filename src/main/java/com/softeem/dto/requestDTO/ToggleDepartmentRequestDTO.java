package com.softeem.dto.requestDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author panpan@softeem.com
 * @description
 * @since 2021/10/20 20:16
 */
@ApiModel(description = "切换单个部门状态RequestDTO")
@Data
public class ToggleDepartmentRequestDTO implements Serializable {

    private static final long serialVersionUID = -2583236811721217476L;

    @ApiModelProperty(value = "部门id",example = "1")
    private Integer depId;
    @ApiModelProperty(value = "当前状态",example = "1")
    private Integer status;


}
