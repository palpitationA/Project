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
@ApiModel(description = "切换单个报销单状态RequestDTO")
@Data
public class ToggleExpenseRequestDTO implements Serializable {

    private static final long serialVersionUID = -2583236811721217476L;

    @ApiModelProperty(value = "报销单id",example = "1")
    private Integer exeId;
    @ApiModelProperty(value = "当前状态",example = "1")
    private Integer status;


}
