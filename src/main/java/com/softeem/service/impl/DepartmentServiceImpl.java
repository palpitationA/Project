package com.softeem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.softeem.dto.requestDTO.DepartmentListReqeustDTO;
import com.softeem.dto.requestDTO.ToggleDepartmentRequestDTO;
import com.softeem.dto.responseDTO.DepartmentActiveListResponseDTO;
import com.softeem.dto.responseDTO.DepartmentListResponseDTO;
import com.softeem.entity.Department;
import com.softeem.dao.DepartmentDao;
import com.softeem.service.DepartmentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 部门表(Department)表服务实现类
 *
 * @author muzi
 * @since 2021-05-15 14:17:00
 */
@Service("departmentService")
public class DepartmentServiceImpl implements DepartmentService {
    @Resource
    private DepartmentDao departmentDao;


    /**
     * 通过ID查询单条数据
     *
     * @param depId 主键
     * @return 实例对象
     */
    @Override
    public Department queryById(Integer depId) {
        return this.departmentDao.queryById(depId);
    }


    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Department> queryAllByLimit(int offset, int limit) {
        return this.departmentDao.queryAllByLimit(offset, limit);
    }


    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public Department insert(Department department) {
        /**
         * 先根据部门名称和地址查询是否重命,如果重命抛出异常,如果没有重命,则正常插入
         */
        try {
            Integer count = departmentDao.selectCountByNameAndAddress(department);
            if (count > 0) {
                throw new RuntimeException("该地址下已经存在同名部门!!");
            }
            departmentDao.insert(department);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return department;
    }




    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 实例对象
     */
    @Override
    public Department update(Department department) {
        try {
            Integer count = departmentDao.selectCountByNameAndAddress(department);
            if (count > 0) {
                throw new RuntimeException("该地址下已经存在同名部门!!");
            }
            departmentDao.update(department);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return this.queryById(department.getDepId());
    }




    /**
     * 通过主键删除数据
     *
     * @param depId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer depId) {
        return this.departmentDao.deleteById(depId) > 0;
    }



    @Override
    public Map<String, Object> queryByPageList(DepartmentListReqeustDTO reqeustDTO) {
        Map<String, Object> map = new HashMap<>();
        try {
            PageHelper.startPage(reqeustDTO.getPageNum(), reqeustDTO.getPageSize());
            Page<DepartmentListResponseDTO> departmentList = (Page) departmentDao.queryPageList(reqeustDTO);
            map.put("success", true);
            map.put("data", new PageInfo(departmentList));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询部门列表失败");
        }
        return map;
    }


    @Override
    public void toggleStatus(ToggleDepartmentRequestDTO department) {
        Integer status = department.getStatus();
        if (1 == status) {
            departmentDao.updateFailureStatusById(department.getDepId());
        } else {
            departmentDao.updateSuccessStatusById(department.getDepId());
        }
    }


    @Override
    public Map<String, Object> queryActiveList() {
        Map<String, Object> map = new HashMap<>();
        try {
            List<DepartmentActiveListResponseDTO> departmentList = departmentDao.queryActiveList();
            map.put("success", true);
            map.put("data", departmentList);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("获取有效部门列表失败",e);
        }
        return map;
    }
}
