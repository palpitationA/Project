package com.softeem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.softeem.dao.DepartmentDao;
import com.softeem.dao.EmployeeDao;
import com.softeem.dao.PositionDao;
import com.softeem.dto.EmployeeDTO;
import com.softeem.dto.requestDTO.EmployeeListReqeustDTO;
import com.softeem.dto.requestDTO.ToggleEmployeeRequestDTO;
import com.softeem.dto.responseDTO.DepartmentActiveListResponseDTO;
import com.softeem.dto.responseDTO.EmployeeResponseDTO;
import com.softeem.dto.responseDTO.PositionActiveListResponseDTO;
import com.softeem.entity.Employee;
import com.softeem.service.EmployeeService;
import com.softeem.util.MD5Util;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 员工表(Employee)表服务实现类
 *
 * @author muzi
 * @since 2021-05-15 14:02:57
 */
@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {
    @Resource
    private EmployeeDao employeeDao;
    @Autowired
    private DepartmentDao departmentDao;
    @Autowired
    private PositionDao positionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param emId 主键
     * @return 实例对象
     */
    @Override
    public EmployeeResponseDTO queryById(Integer emId) throws Exception{
        EmployeeResponseDTO responseDTO = new EmployeeResponseDTO();
        try {
            /**
             * 获取部门下拉列表
             * 获取职位下拉列表
             * 获取员工信息
             */
            EmployeeDTO employeeDTO = employeeDao.queryById(emId);
            List<DepartmentActiveListResponseDTO> departmentList = departmentDao.queryActiveList();
            List<PositionActiveListResponseDTO> positionList = positionDao.queryActiveList();
            responseDTO.setEmployeeDTO(employeeDTO);
            responseDTO.setDepartmentList(departmentList);
            responseDTO.setPositionList(positionList);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException(e.getMessage());
        }
        return responseDTO;
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Employee> queryAllByLimit(int offset, int limit) {
        return this.employeeDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @Override
    public Employee insert(Employee employee) {
        //设置默认密码
        employee.setPassword(MD5Util.getMD5("123456"));
        this.employeeDao.insert(employee);
        return employee;
    }

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    @Override
    public Integer update(Employee employee) {
        return employeeDao.update(employee);
    }

    /**
     * 通过主键删除数据
     *
     * @param emId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer emId) {
        return this.employeeDao.deleteById(emId) > 0;
    }

    @Override
    public EmployeeDTO getEmInfoByUsernameAndPassword(String userName, String password) {
        return employeeDao.queryEmInfoByUsernameAndPassword(userName, MD5Util.getMD5(password));
    }

    @Override
    public Map<String, Object> queryByPageList(EmployeeListReqeustDTO requestDTO) {

        Map<String, Object> map = new HashMap<>();
        try {
            PageHelper.startPage(requestDTO.getPageNum(), requestDTO.getPageSize());
            Page<EmployeeDTO> employeeList = (Page) employeeDao.queryPageList(requestDTO);
            map.put("success", true);
            map.put("data", new PageInfo(employeeList));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询员工列表失败");
        }
        return map;
    }

    @Override
    public void toggleStatus(ToggleEmployeeRequestDTO requestDTO) {
        Integer status = requestDTO.getStatus();
        if (1 == status) {
            employeeDao.updateFailureStatusById(requestDTO.getEmId());
        } else {
            employeeDao.updateSuccessStatusById(requestDTO.getEmId());
        }

    }
}
