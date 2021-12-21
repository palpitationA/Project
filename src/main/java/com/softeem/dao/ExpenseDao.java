package com.softeem.dao;

import com.softeem.dto.requestDTO.ExpensetListReqeustDTO;
import com.softeem.dto.responseDTO.ExpenseActiveListResponseDTO;
import com.softeem.entity.Expense;
import org.apache.ibatis.annotations.Param;
import java.util.List;

/**
 * 报销表(Expense)表数据库访问层
 *
 * @author panpan
 * @since 2021-10-15 14:17:22
 */
public interface ExpenseDao {


    /**
     * 通过ID查询单条数据
     *
     * @param expenseId 主键
     * @return 实例对象
     */
    Expense queryById(Integer expenseId);


    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Expense> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param expense 实例对象
     * @return 对象列表
     */
    List<Expense> queryAll(Expense expense);


    /**
     * 新增数据
     *
     * @param expense 实例对象
     * @return 影响行数
     */
    int insert(Expense expense);


    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Expense> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Expense> entities);


    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Expense> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Expense> entities);


    /**
     * 修改数据
     *
     * @param expense 实例对象
     * @return 影响行数
     */
    int update(Expense expense);


    /**
     * 通过主键删除数据
     *
     * @param expenseId 主键
     * @return 影响行数
     */
    int deleteById(Integer expenseId);


    /**
     * 查询部门列表
     * @return
     */
    List<Expense> queryPageList(ExpensetListReqeustDTO reqeustDTO);

    void updateFailureStatusById(Integer expenseId);

    void updateSuccessStatusById(Integer expenseId);

    List<ExpenseActiveListResponseDTO> queryActiveList();
}

