package com.softeem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softeem.dto.requestDTO.ExpensetListReqeustDTO;
import com.softeem.dto.requestDTO.ToggleExpenseRequestDTO;
import com.softeem.entity.Employee;
import com.softeem.entity.Expense;
import com.softeem.service.EmployeeService;
import com.softeem.service.ExpenseService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

/**
 * @author panpan@softeem.com
 * @description
 * @since 2021/10/22 21:19
 */
@Controller
@RequestMapping("/expense")
@Api(tags = "报销单管理模块")
public class ExpenseController extends BaseController{

    @Autowired
    private ExpenseService expenseService;




    @ApiOperation(value = "跳转至列表的路由")
    @GetMapping("/toList")
    public String toList(){
        request.getSession().setAttribute("pageName", "报销单管理");
        return "expense-list";
    }



    @ApiOperation(value = "跳转至新增报销单的路由")
    @GetMapping("/toAddExpense")
    public String toAddExpense(){
        request.getSession().setAttribute("pageName", "新增报销单");
        return "expense-add";
    }



    @ApiOperation(value = "跳转至查看某个报销单信息的路由")
    @GetMapping("/toExpenseInfo")
    public String toExpenseInfo(){
        request.getSession().setAttribute("pageName", "报销单详情");
        return "expense-info";
    }



    @ApiOperation(value = "跳转至报销单修改的路由")
    @GetMapping("/toExpenseEdit")
    public String toExpenseEdit(){
        request.getSession().setAttribute("pageName", "编辑报销单");
        return "expense-edit";
    }



    @ApiOperation(value = "获取报销单列表(涉及到分页,条件查询)")
    @PostMapping("/getList")
    @ResponseBody
    public Map<String,Object> getList(@RequestBody ExpensetListReqeustDTO reqeustDTO){
        Map<String, Object> map = null;
        System.out.println(1111);
        System.out.println(reqeustDTO);
        try {
            map = expenseService.queryByPageList(reqeustDTO);
            for (Map.Entry<String, Object> map1 : map.entrySet()) {
                System.out.println(map1.getValue());
            }
        } catch (Exception e) {
            map = new HashMap();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }



    @ApiOperation(value = "切换单个报销单状态")
    @PostMapping("/toggleExpenseStatus")
    @ResponseBody
    public Map<String,Object> toggleExpenseStatus(@RequestBody ToggleExpenseRequestDTO requestDTO){
        Map<String, Object> map = new HashMap<>();
        try {
            System.out.println(requestDTO);
            expenseService.toggleStatus(requestDTO);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            return map;
        }
        map.put("success", true);
        return map;
    }


    @ApiOperation(value = "根据id查询报销单信息")
    @PostMapping("/queryExpenseById")
    @ResponseBody
    public Map<String,Object> queryExpenseById(){
        Map<String, Object> map = new HashMap<>();
        Integer expenseId = Integer.decode(request.getParameter("expenseId"));
        try {
            Expense expense = expenseService.queryById(expenseId);
            System.out.println(expense);
            map.put("success", true);
            map.put("data", expense);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }



    @ApiOperation(value = "编辑报销单信息")
    @PostMapping("/editExpense")
    @ResponseBody
    public Map<String,Object> editExpense(@RequestParam String expenseStr){
        Map<String, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        Expense expense = null;
        try{
            expense = mapper.readValue(expenseStr, Expense.class);
            System.out.println(expense);
            expenseService.update(expense);
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }





    @ApiOperation(value = "新增报销单信息")
    @PostMapping("/insertExpense")
    @ResponseBody
    public Map<String,Object> insertExpense(@RequestParam String expenseStr){
        Map<String, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        Expense expense = null;
        try{
            System.out.println(111);
            System.out.println(expenseStr);
            expense = mapper.readValue(expenseStr, Expense.class);
            System.out.println(expense);
            expenseService.insert(expense);
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
            map = expenseService.queryActiveList();
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }

        return map;
    }
}
