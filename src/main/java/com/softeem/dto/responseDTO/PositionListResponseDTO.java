package com.softeem.dto.responseDTO;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.softeem.enums.StatusEnum;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

/**
 * @author muzi@softeem.com
 * @description
 * @since 2021/5/18 21:32
 */
@ApiModel(description = "职位列表ResponseDTO")
@Data
public class PositionListResponseDTO implements Serializable {

    private static final long serialVersionUID = -5436108950797359648L;

    /**
     * 职位id
     */
    @ApiModelProperty(value = "职位id")
    private Integer positionId;

    /**
     * 职位名称
     */
    @ApiModelProperty(value = "职位名称")
    private String positionName;

    /**
     * 创建时间
     */
    @ApiModelProperty(value = "创建时间")
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss",timezone = "GMT+8")
    private Date createTime;

    /**
     * 1代表有效,0代表无效
     */
    @ApiModelProperty(value = "1代表有效,0代表无效")
    private Integer status;

//    private String statusName = StatusEnum.stateOf(getStatus()).getStatusName();



}
