package com.softeem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.softeem.dao.ExpenseDao;
import com.softeem.dto.requestDTO.ExpensetListReqeustDTO;
import com.softeem.dto.requestDTO.ToggleExpenseRequestDTO;
import com.softeem.dto.responseDTO.ExpenseActiveListResponseDTO;
import com.softeem.dto.responseDTO.ExpenseListResponseDTO;
import com.softeem.entity.Expense;
import com.softeem.service.ExpenseService;
import org.springframework.stereotype.Service;
import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 报销表(Expense)表服务实现类
 *
 * @author muzi
 * @since 2021-05-15 14:17:22
 */
@Service("expenseService")
public class ExpenseServiceImpl implements ExpenseService {
    @Resource
    private ExpenseDao expenseDao;

    /**
     * 通过ID查询单条数据
     *
     * @param expenseId 主键
     * @return 实例对象
     */
    @Override
    public Expense queryById(Integer expenseId) {
        return this.expenseDao.queryById(expenseId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Expense> queryAllByLimit(int offset, int limit) {
        return this.expenseDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param expense 实例对象
     * @return 实例对象
     */
    @Override
    public Expense insert(Expense expense) {
        this.expenseDao.insert(expense);
        return expense;
    }

    /**
     * 修改数据
     *
     * @param expense 实例对象
     * @return 实例对象
     */
    @Override
    public Expense update(Expense expense) {
        this.expenseDao.update(expense);
        return this.queryById(Integer.parseInt(expense.getExpenseId()));
    }

    /**
     * 通过主键删除数据
     *
     * @param expenseId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer expenseId) {
        return this.expenseDao.deleteById(expenseId) > 0;
    }

    @Override
    public Map<String, Object> queryByPageList(ExpensetListReqeustDTO reqeustDTO) {
        Map<String, Object> map = new HashMap<>();
        try {
            PageHelper.startPage(reqeustDTO.getPageNum(), reqeustDTO.getPageSize());
            Page<Expense> expenseList = (Page) expenseDao.queryPageList(reqeustDTO);
            for (Expense expense : expenseList) {
                System.out.println("serviceImpl"+expense);
            }
            map.put("success", true);
            map.put("data", new PageInfo(expenseList));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询报销列表失败");
        }
        return map;
    }

    @Override
    public void toggleStatus(ToggleExpenseRequestDTO expense) {
        Integer status = expense.getStatus();
        if (1 == status) {
            expenseDao.updateFailureStatusById(expense.getExeId());
        } else {
            expenseDao.updateSuccessStatusById(expense.getExeId());
        }
    }

    @Override
    public Map<String, Object> queryActiveList() {
        Map<String, Object> map = new HashMap<>();
        try {
            List<ExpenseActiveListResponseDTO> departmentList = expenseDao.queryActiveList();
            map.put("success", true);
            map.put("data", departmentList);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("获取有效报销列表失败",e);
        }
        return map;
    }
}
