package com.softeem.dto.responseDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author panpan@softeem.com
 * @description
 * @since 2021/5/25 22:07
 */
@ApiModel(description = "有效职位列表,为下拉列表使用")
@Data
public class PositionActiveListResponseDTO implements Serializable {

    private static final long serialVersionUID = -5690389201227614592L;

    @ApiModelProperty(value = "职位id")
    private Integer positionId;
    @ApiModelProperty(value = "职位名称")
    private String positionName;

}
