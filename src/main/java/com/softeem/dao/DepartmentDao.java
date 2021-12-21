package com.softeem.dao;

import com.softeem.dto.requestDTO.DepartmentListReqeustDTO;
import com.softeem.dto.responseDTO.DepartmentActiveListResponseDTO;
import com.softeem.dto.responseDTO.DepartmentListResponseDTO;
import com.softeem.entity.Department;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 部门表(Department)表数据库访问层
 *
 * @author panpan
 * @since 2021-10-15 14:17:00
 */
public interface DepartmentDao {



    /**
     * 通过ID查询单条数据
     *
     * @param depId 主键
     * @return 实例对象
     */
    Department queryById(Integer depId);



    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Department> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);




    /**
     * 通过实体作为筛选条件查询
     *
     * @param department 实例对象
     * @return 对象列表
     */
    List<Department> queryAll(Department department);



    /**
     * 新增数据
     *
     * @param department 实例对象
     * @return 影响行数
     */
    int insert(Department department);



    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Department> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Department> entities);



    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Department> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Department> entities);



    /**
     * 修改数据
     *
     * @param department 实例对象
     * @return 影响行数
     */
    int update(Department department);



    /**
     * 通过主键删除数据
     *
     * @param depId 主键
     * @return 影响行数
     */
    int deleteById(Integer depId);


    /**
     * 查询部门列表
     * @return
     */
    List<DepartmentListResponseDTO> queryPageList(DepartmentListReqeustDTO reqeustDTO);


    void updateFailureStatusById(Integer depId);


    void updateSuccessStatusById(Integer depId);


    Integer selectCountByNameAndAddress(Department department);


    /**
     * 有效的部门列表
     * @return
     */
    List<DepartmentActiveListResponseDTO> queryActiveList();



}

