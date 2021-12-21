package com.softeem.controller;


import com.fasterxml.jackson.databind.ObjectMapper;
import com.softeem.dto.requestDTO.DepartmentListReqeustDTO;
import com.softeem.dto.requestDTO.ToggleDepartmentRequestDTO;
import com.softeem.entity.Department;
import com.softeem.service.DepartmentService;
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
 * @since 2021/10/18 20:19
 */
@Controller
@RequestMapping("/department")
@Api(tags = "部门管理模块")
public class DepartmentController extends BaseController{


    @Autowired
    private DepartmentService departmentService;



    @ApiOperation(value = "跳转至列表的路由")
    @GetMapping("/toList")
    public String toList(){
        request.getSession().setAttribute("pageName", "部门管理");
        return "department-list";
    }


    @ApiOperation(value = "跳转至新增部门的路由")
    @GetMapping("/toAddDepartment")
    public String toAddDepartment(){
        request.getSession().setAttribute("pageName", "新增部门");
        return "department-add";
    }



    @ApiOperation(value = "跳转至查看某个部门信息的路由")
    @GetMapping("/toDepartmentInfo")
    public String toDepartmentInfo(){
        request.getSession().setAttribute("pageName", "部门详情");
        return "department-info";
    }



    @ApiOperation(value = "跳转至部门修改的路由")
    @GetMapping("/toDepartmentEdit")
    public String toDepartmentEdit(){
        request.getSession().setAttribute("pageName", "编辑部门");
        return "department-edit";
    }



    @ApiOperation(value = "获取部门列表(涉及到分页,条件查询)")
    @PostMapping("/getList")
    @ResponseBody
    public Map<String,Object> getList(@RequestBody DepartmentListReqeustDTO reqeustDTO){
        Map<String, Object> map = null;
        try {
            System.out.println("aaa");
            map = departmentService.queryByPageList(reqeustDTO);
            for(String key:map.keySet()){
                System.out.println(key+":"+map.get(key));
            }
        } catch (Exception e) {
            map = new HashMap();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }


    @ApiOperation(value = "切换单个部门状态")
    @PostMapping("/toggleDepartmentStatus")
    @ResponseBody
    public Map<String,Object> toggleDepartmentStatus(@RequestBody ToggleDepartmentRequestDTO requestDTO){
        Map<String, Object> map = new HashMap<>();
        try {
            departmentService.toggleStatus(requestDTO);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            return map;
        }
        map.put("success", true);
        return map;
    }


    @ApiOperation(value = "根据id查询部门信息")
    @PostMapping("/queryDepartmentById")
    @ResponseBody
    public Map<String,Object> queryDepartmentById(){
        Map<String, Object> map = new HashMap<>();
        Integer depId = Integer.decode(request.getParameter("depId"));
        try {
            Department department = departmentService.queryById(depId);
            map.put("success", true);
            map.put("data", department);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }


    @ApiOperation(value = "编辑部门信息")
    @PostMapping("/editDepartment")
    @ResponseBody
    public Map<String,Object> editDepartment(@RequestParam String departmentStr){
        Map<String, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        Department department = null;
        try{
            department = mapper.readValue(departmentStr, Department.class);
            departmentService.update(department);
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }


    @ApiOperation(value = "新增部门信息")
    @PostMapping("/insertDepartment")
    @ResponseBody
    public Map<String,Object> insertDepartment(@RequestParam String departmentStr){
        Map<String, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        Department department = null;
        try{
            department = mapper.readValue(departmentStr, Department.class);
            System.out.println(department);
            departmentService.insert(department);
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }


    @PostMapping("/getActiveList")
    @ResponseBody
    public Map<String,Object> getActiveList(){
        Map<String, Object> map = null;
        try {
            map = departmentService.queryActiveList();
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }

        return map;
    }

}
