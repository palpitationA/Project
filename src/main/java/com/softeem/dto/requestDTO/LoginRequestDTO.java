package com.softeem.dto.requestDTO;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * @author muzi@softeem.com
 * @description
 * @since 2021/5/13 22:10
 */
@ApiModel(value = "登录",description = "用户登录的DTO")
@Data
public class LoginRequestDTO implements Serializable {

    private static final long serialVersionUID = 6123862434504850517L;

    /**
     * 用户名
     */
    @ApiModelProperty(value = "用户名",required = true,example = "13100000001")
    private String userName;

    /**
     * 密码
     */
    @ApiModelProperty(value = "密码",required = true,example = "123456")
    private String password;

    @ApiModelProperty(value = "用户输入的验证码")
    private String verifyCode;

    @ApiModelProperty(value = "是否需要校验验证码",required = true,example = "false")
    private Boolean needVerify;



}
