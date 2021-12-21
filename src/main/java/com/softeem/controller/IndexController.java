package com.softeem.controller;


import com.softeem.dto.EmployeeDTO;
import com.softeem.dto.requestDTO.LoginRequestDTO;
import com.softeem.service.EmployeeService;
import com.softeem.util.CodeUtil;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

/**
 * @author panpan@softeem.com
 * @description
 * @since 2021/10/13 21:36
 */
@Api(tags = "登陆登出模块")
@Controller
public class IndexController extends BaseController {

    @Autowired
    private EmployeeService employeeService;

    /**
     * 登录的路由
     *
     * @return
     */
    @ApiOperation(value = "跳转到登录的路由")
//    @RequestMapping(value = "/login",method = RequestMethod.GET)
    @GetMapping("/login")
    public String login() {
        return "login";
    }



    @ApiOperation(value = "登录校验")
    @PostMapping("/checkLogin")
    @ResponseBody
    public Map<String, Object> checkLogin(@RequestBody LoginRequestDTO loginRequestDTO) {
        Map<String, Object> map = new HashMap<>();
        //是否需要对验证码进行验证
        Boolean needVerify = loginRequestDTO.getNeedVerify();
        if (needVerify && !CodeUtil.checkVerifyCode(loginRequestDTO.getVerifyCode(), request)) {
            map.put("success", false);
            map.put("errMsg", "验证码错误,请重新登录~");
            return map;
        }
        //参数校验
        String userName = loginRequestDTO.getUserName();
        String password = loginRequestDTO.getPassword();
        if (userName != null && password != null && !"".equals(userName)
                && !"".equals(password)) {
            EmployeeDTO userInfo = employeeService.getEmInfoByUsernameAndPassword(userName, password);
            if (null != userInfo) {
                map.put("success", true);
                request.getSession().setAttribute("userInfo", userInfo);
            } else {
                map.put("success", false);
                map.put("errMsg", "用户名或者密码错误,同时请确认该员工在职");
            }
        } else {
            map.put("success", false);
            map.put("errMsg", "用户名或者密码不能为空");
        }
        return map;
    }



    @GetMapping("/main")
    @ApiOperation(value = "主页面路由")
    public String mainPage(){
        request.getSession().setAttribute("pageName", "首页");
        return "main";
    }



    @ApiOperation(value = "退出登录")
    @PostMapping("/logout")
    @ResponseBody
    public Map<String,Object> quit(){
        Map<String, Object> map = new HashMap<>();
        request.getSession().setAttribute("userInfo", null);
        map.put("success", true);
        return map;
    }


}
