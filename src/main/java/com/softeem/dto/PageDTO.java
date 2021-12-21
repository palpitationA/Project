package com.softeem.dto;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author panpan@softeem.com
 * @description 分页DTO
 * @since 2021/10/22 14:16
 */
@ApiModel(description = "分页DTO")
@Data
public class PageDTO implements Serializable {

    private static final long serialVersionUID = 546125947779828553L;

    /**
     * 页码，从1开始
     */
    @ApiModelProperty(value = "页码，从1开始")
    private int pageNum = 1;
    /**
     * 页面大小
     */
    @ApiModelProperty(value = "页面大小")
    private int pageSize = 10;
    /**
     * 总数
     */
    @ApiModelProperty(value = "总数")
    private long total;
    /**
     * 总页数
     */
    @ApiModelProperty(value = "总页数")
    private int pages;


}
