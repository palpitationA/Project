package com.softeem.service;

import com.softeem.dto.requestDTO.DepartmentListReqeustDTO;
import com.softeem.dto.requestDTO.PositionListReqeustDTO;
import com.softeem.dto.requestDTO.ToggleDepartmentRequestDTO;
import com.softeem.dto.requestDTO.TogglePositionRequestDTO;
import com.softeem.entity.Position;

import java.util.List;
import java.util.Map;

/**
 * 职位表(Position)表服务接口
 *
 * @author panpan
 * @since 2021-10-15 14:17:22
 */
public interface PositionService {

    /**
     * 通过ID查询单条数据
     *
     * @param positionId 主键
     * @return 实例对象
     */
    Position queryById(Integer positionId);

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Position> queryAllByLimit(int offset, int limit);

    /**
     * 新增数据
     *
     * @param position 实例对象
     * @return 实例对象
     */
    Position insert(Position position);

    /**
     * 修改数据
     *
     * @param position 实例对象
     * @return 实例对象
     */
    Position update(Position position);

    /**
     * 通过主键删除数据
     *
     * @param positionId 主键
     * @return 是否成功
     */
    boolean deleteById(Integer positionId);

    /**
     * 获取职位信息列表
     * @return
     */
    Map<String, Object> queryByPageList(PositionListReqeustDTO reqeustDTO);

    void toggleStatus(TogglePositionRequestDTO requestDTO);

    Map<String, Object> queryActiveList();
}
