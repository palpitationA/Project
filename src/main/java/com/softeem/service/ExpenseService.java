package com.softeem.service;


import com.softeem.dto.requestDTO.ExpensetListReqeustDTO;
import com.softeem.dto.requestDTO.ToggleExpenseRequestDTO;
import com.softeem.entity.Expense;

import java.util.List;
import java.util.Map;

/**
 * 职位表(Expense)表服务接口
 *
 * @author panpan
 * @since 2021-10-15 14:17:22
 */
public interface ExpenseService {

    /**
     * 通过ID查询单条数据
     *
     * @param expenseId 主键
     * @return 实例对象
     */
    Expense queryById(Integer expenseId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Expense> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param expense 实例对象
     * @return 实例对象
     */
    Expense insert(Expense expense);

    /**
     * 修改数据
     *
     * @param expense 实例对象
     * @return 实例对象
     */
    Expense update(Expense expense);

    /**
     * 通过主键删除数据
     *
     * @param expenseId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer expenseId);

    /**
     * 获取职位信息列表
     * @return
     */
    Map<String, Object> queryByPageList(ExpensetListReqeustDTO reqeustDTO);

    void toggleStatus(ToggleExpenseRequestDTO requestDTO);

    Map<String, Object> queryActiveList();
}
