package com.softeem.controller;

import io.swagger.annotations.Api;
import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

/**
 * @author panpan@softeem.com
 * @description
 * @since 2021/10/15 14:47
 */
@Controller
public class BaseController {

    @Resource
    HttpServletRequest request;
}
