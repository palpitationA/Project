package com.softeem.dto.requestDTO;

import com.softeem.dto.PageDTO;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author muzi@softeem.com
 * @description
 * @since 2021/5/20 21:19
 */
@ApiModel(description = "获取职位列表RequestDTO")
@Data
public class PositionListReqeustDTO extends PageDTO implements Serializable {

    private static final long serialVersionUID = 7384274751517806605L;

    @ApiModelProperty(value = "职位名称关键字",example = "")
    private String positionName;
    @ApiModelProperty(value = "状态",example = "")
    private Integer status;


}
