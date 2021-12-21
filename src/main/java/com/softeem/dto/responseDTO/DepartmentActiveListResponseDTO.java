package com.softeem.dto.responseDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author panpan@softeem.com
 * @description
 * @since 2021/10/25 22:07
 */
@ApiModel(description = "有效部门列表,为下拉列表使用")
@Data
public class DepartmentActiveListResponseDTO implements Serializable {

    private static final long serialVersionUID = 8563207431292949603L;

    @ApiModelProperty(value = "部门id")
    private Integer depId;
    @ApiModelProperty(value = "部门名称")
    private String name;


}
