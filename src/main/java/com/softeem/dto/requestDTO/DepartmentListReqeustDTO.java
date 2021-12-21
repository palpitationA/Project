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
@ApiModel(description = "获取部门列表RequestDTO")
@Data
public class DepartmentListReqeustDTO extends PageDTO implements Serializable {

    private static final long serialVersionUID = 8123672196062695732L;

    @ApiModelProperty(value = "部门名称关键字",example = "")
    private String name;
    @ApiModelProperty(value = "部门地址关键字",example = "")
    private String address;
    @ApiModelProperty(value = "状态",example = "")
    private Integer status;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }
}
