package com.softeem.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.softeem.dto.requestDTO.PositionListReqeustDTO;
import com.softeem.dto.requestDTO.TogglePositionRequestDTO;
import com.softeem.entity.Position;
import com.softeem.service.PositionService;
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
 * @since 2021/10/22 21:19
 */
@Controller
@RequestMapping("/position")
@Api(tags = "职位管理模块")
public class PositionController extends BaseController{

    @Autowired
    private PositionService positionService;



    @ApiOperation(value = "跳转至列表的路由")
    @GetMapping("/toList")
    public String toList(){
        request.getSession().setAttribute("pageName", "职位管理");
        return "position-list";
    }



    @ApiOperation(value = "跳转至新增职位的路由")
    @GetMapping("/toAddPosition")
    public String toAddPosition(){
        request.getSession().setAttribute("pageName", "新增职位");
        return "position-add";
    }



    @ApiOperation(value = "跳转至查看某个职位信息的路由")
    @GetMapping("/toPositionInfo")
    public String toPositionInfo(){
        request.getSession().setAttribute("pageName", "职位详情");
        return "position-info";
    }



    @ApiOperation(value = "跳转至职位修改的路由")
    @GetMapping("/toPositionEdit")
    public String toPositionEdit(){
        request.getSession().setAttribute("pageName", "编辑职位");
        return "position-edit";
    }



    @ApiOperation(value = "获取职位列表(涉及到分页,条件查询)")
    @PostMapping("/getList")
    @ResponseBody
    public Map<String,Object> getList(@RequestBody PositionListReqeustDTO reqeustDTO){
        Map<String, Object> map = null;
        try {
            map = positionService.queryByPageList(reqeustDTO);
        } catch (Exception e) {
            map = new HashMap();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }



    @ApiOperation(value = "切换单个职位状态")
    @PostMapping("/togglePositionStatus")
    @ResponseBody
    public Map<String,Object> togglePositionStatus(@RequestBody TogglePositionRequestDTO requestDTO){
        Map<String, Object> map = new HashMap<>();
        try {
            positionService.toggleStatus(requestDTO);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
            return map;
        }
        map.put("success", true);
        return map;
    }


    @ApiOperation(value = "根据id查询职位信息")
    @PostMapping("/queryPositionById")
    @ResponseBody
    public Map<String,Object> queryPositionById(){
        Map<String, Object> map = new HashMap<>();
        Integer positionId = Integer.decode(request.getParameter("positionId"));
        try {
            Position position = positionService.queryById(positionId);
            map.put("success", true);
            map.put("data", position);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }



    @ApiOperation(value = "编辑职位信息")
    @PostMapping("/editPosition")
    @ResponseBody
    public Map<String,Object> editPosition(@RequestParam String positionStr){
        Map<String, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        Position position = null;
        try{
            position = mapper.readValue(positionStr, Position.class);
            positionService.update(position);
            map.put("success", true);
        } catch (Exception e) {
            e.printStackTrace();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }
        return map;
    }





    @ApiOperation(value = "新增职位信息")
    @PostMapping("/insertPosition")
    @ResponseBody
    public Map<String,Object> insertPosition(@RequestParam String positionStr){
        Map<String, Object> map = new HashMap<>();
        ObjectMapper mapper = new ObjectMapper();
        Position position = null;
        try{
            position = mapper.readValue(positionStr, Position.class);
            positionService.insert(position);
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
            map = positionService.queryActiveList();
        } catch (Exception e) {
            map = new HashMap<>();
            map.put("success", false);
            map.put("errMsg", e.getMessage());
        }

        return map;
    }
}
