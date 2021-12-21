package com.softeem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softeem.dto.requestDTO.EmployeeListReqeustDTO;
import com.softeem.dto.requestDTO.ToggleEmployeeRequestDTO;
import com.softeem.dto.responseDTO.EmployeeResponseDTO;
import com.softeem.entity.Employee;
import com.softeem.service.EmployeeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

/**
 * @author panpan@softeem.com
 * @description
 * @since 2021/10/25 19:50
 */
@Controller
@RequestMapping("/employee")
@Api(tags = "员工管理模块")
public class EmployeeController extends BaseController{

    @Autowired
    private EmployeeService employeeService;



    @ApiOperation(value = "跳转至列表的路由")
    @GetMapping("/toList")
    public String toList(){
        request.getSession().setAttribute("pageName", "员工管理");
        return "employee-list";
    }


    @ApiOperation(value = "跳转至员工详情页面的路由")
    @GetMapping("/toEmployeeInfo")
    public String toEmployeeInfo(){
        request.getSession().setAttribute("pageName", "员工详情");
        return "employee-info";
    }



    @ApiOperation(value = "跳转至修改员工信息页面的路由")
    @GetMapping("/toEmployeeEdit")
    public String toEmployeeEdit(){
        request.getSession().setAttribute("pageName", "修改信息");
        return "employee-edit";
    }



    @ApiOperation(value = "跳转至新增部门的路由")
    @GetMapping("/toAddEmployee")
    public String toAddEmployee(){
        request.getSession().setAttribute("pageName", "新增员工");
        return "employee-add";
    }



    @ApiOperation(value = "获取员工列表(涉及到分页,条件查询)")
    @PostMapping("/getList")
    @ResponseBody
    public Map<String,Object> getList(@RequestBody EmployeeListReqeustDTO requestDTO){
        Map<String, Object> map = null;
        try {
            map = employeeService.queryByPageList(requestDTO);
        } catch (Exception e) {
            map = new HashMap();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }




    @ApiOperation(value = "切换单个员工状态")
    @PostMapping("/toggleEmployeeStatus")
    @ResponseBody
    public Map<String,Object> toggleEmployeeStatus(@RequestBody ToggleEmployeeRequestDTO requestDTO){
        Map<String, Object> map = new HashMap<>();
        try {
            employeeService.toggleStatus(requestDTO);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            return map;
        }
        map.put("success", true);
        return map;
    }



    @ApiOperation(value = "根据id查询员工信息")
    @PostMapping("/queryEmployeeById")
    @ResponseBody
    public Map<String,Object> queryEmployeeById(){
        Map<String, Object> map = new HashMap<>();
        Integer emId = Integer.decode(request.getParameter("emId"));
        try {
            EmployeeResponseDTO responseDTO = employeeService.queryById(emId);
            map.put("success", true);
            map.put("data", responseDTO);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }


    
    @ApiOperation(value = "编辑员工信息")
    @PostMapping("/editEmployee")
    @ResponseBody
    public Map<String,Object> editEmployee(@RequestParam String employeeStr){
        Map<String, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        Employee employee = null;
        try{
            employee = mapper.readValue(employeeStr, Employee.class);
            employeeService.update(employee);
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }



    @ApiOperation(value = "新增员工信息")
    @PostMapping("/insertEmployee")
    @ResponseBody
    public Map<String,Object> insertEmployee(@RequestParam String employeeStr){
        Map<String, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        Employee employee = null;
        try{
            employee = mapper.readValue(employeeStr, Employee.class);
            employeeService.insert(employee);
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }
}
