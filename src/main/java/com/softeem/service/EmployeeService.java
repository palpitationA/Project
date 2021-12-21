package com.softeem.service;

import com.softeem.dto.EmployeeDTO;
import com.softeem.dto.requestDTO.DepartmentListReqeustDTO;
import com.softeem.dto.requestDTO.EmployeeListReqeustDTO;
import com.softeem.dto.requestDTO.ToggleDepartmentRequestDTO;
import com.softeem.dto.requestDTO.ToggleEmployeeRequestDTO;
import com.softeem.dto.responseDTO.EmployeeResponseDTO;
import com.softeem.entity.Employee;

import java.util.List;
import java.util.Map;

/**
 * 员工表(Employee)表服务接口
 *
 * @author panpan
 * @since 2021-10-15 14:02:57
 */
public interface EmployeeService {

    /**
     * 通过ID查询单条数据
     *
     * @param emId 主键
     * @return 实例对象
     */
    EmployeeResponseDTO queryById(Integer emId) throws Exception;

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Employee> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    Employee insert(Employee employee);

    /**
     * 修改数据
     *
     * @param employee 实例对象
     * @return 实例对象
     */
    Integer update(Employee employee);

    /**
     * 通过主键删除数据
     *
     * @param emId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer emId);

    EmployeeDTO getEmInfoByUsernameAndPassword(String userName, String password);

    /**
     * 根据条件获取员工列表
     * @return
     */
    Map<String, Object> queryByPageList(EmployeeListReqeustDTO requestDTO);

    void toggleStatus(ToggleEmployeeRequestDTO requestDTO);
}
