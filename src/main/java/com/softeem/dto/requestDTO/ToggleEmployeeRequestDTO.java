package com.softeem.dto.requestDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author panpan@softeem.com
 * @description
 * @since 2021/10/25 21:50
 */
@ApiModel(description = "切换单个部门状态RequestDTO")
@Data
public class ToggleEmployeeRequestDTO implements Serializable {

    private static final long serialVersionUID = 5285591553704671763L;

    @ApiModelProperty(value = "员工id",example = "2")
    private Integer emId;
    @ApiModelProperty(value = "目前的状态(0代表离职,1代表在职)",example = "1")
    private Integer status;


}
