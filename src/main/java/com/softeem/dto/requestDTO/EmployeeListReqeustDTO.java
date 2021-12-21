package com.softeem.dto.requestDTO;


import com.softeem.dto.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@ApiModel(description = "获取员工列表RequestDTO")
@Data
public class EmployeeListReqeustDTO extends PageDTO implements Serializable {

    private static final long serialVersionUID = -5581636427119434473L;

    @ApiModelProperty(value = "员工姓名",example = "")
    private String name;

    @ApiModelProperty(value = "登录账号",example = "")
    private String loginName;

    @ApiModelProperty(value = "状态 0代表停用 1代表启动",example = "")
    private Integer status;

    @ApiModelProperty(value = "员工姓名",example = "")
    private Integer depId;

    @ApiModelProperty(value = "员工姓名",example = "")
    private Integer positionId;


}