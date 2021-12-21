package com.softeem.dao;

import com.softeem.entity.TTest;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * (TTest)表数据库访问层
 *
 * @author panpan
 * @since 2021-10-11 21:11:36
 */
public interface TTestDao {


    /**
     * 通过ID查询单条数据
     *
     * @param id 主键
     * @return 实例对象
     */
    TTest queryById(Integer id);


    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<TTest> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param tTest 实例对象
     * @return 对象列表
     */
    List<TTest> queryAll(TTest tTest);



    /**
     * 新增数据
     *
     * @param tTest 实例对象
     * @return 影响行数
     */
    int insert(TTest tTest);



    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<TTest> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<TTest> entities);



    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<TTest> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<TTest> entities);



    /**
     * 修改数据
     *
     * @param tTest 实例对象
     * @return 影响行数
     */
    int update(TTest tTest);



    /**
     * 通过主键删除数据
     *
     * @param id 主键
     * @return 影响行数
     */
    int deleteById(Integer id);

}

