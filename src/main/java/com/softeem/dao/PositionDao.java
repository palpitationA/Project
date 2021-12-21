package com.softeem.dao;

import com.softeem.dto.requestDTO.PositionListReqeustDTO;
import com.softeem.dto.responseDTO.PositionActiveListResponseDTO;
import com.softeem.dto.responseDTO.PositionListResponseDTO;
import com.softeem.entity.Position;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 职位表(Position)表数据库访问层
 *
 * @author panpan
 * @since 2021-10-15 14:17:22
 */
public interface PositionDao {


    /**
     * 通过ID查询单条数据
     *
     * @param positionId 主键
     * @return 实例对象
     */
    Position queryById(Integer positionId);


    /**
     * 查询指定行数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    List<Position> queryAllByLimit(@Param("offset") int offset, @Param("limit") int limit);


    /**
     * 通过实体作为筛选条件查询
     *
     * @param position 实例对象
     * @return 对象列表
     */
    List<Position> queryAll(Position position);


    /**
     * 新增数据
     *
     * @param position 实例对象
     * @return 影响行数
     */
    int insert(Position position);


    /**
     * 批量新增数据（MyBatis原生foreach方法）
     *
     * @param entities List<Position> 实例对象列表
     * @return 影响行数
     */
    int insertBatch(@Param("entities") List<Position> entities);


    /**
     * 批量新增或按主键更新数据（MyBatis原生foreach方法）
     *
     * @param entities List<Position> 实例对象列表
     * @return 影响行数
     */
    int insertOrUpdateBatch(@Param("entities") List<Position> entities);


    /**
     * 修改数据
     *
     * @param position 实例对象
     * @return 影响行数
     */
    int update(Position position);


    /**
     * 通过主键删除数据
     *
     * @param positionId 主键
     * @return 影响行数
     */
    int deleteById(Integer positionId);


    /**
     * 查询部门列表
     * @return
     */
    List<PositionListResponseDTO> queryPageList(PositionListReqeustDTO reqeustDTO);

    void updateFailureStatusById(Integer positionId);

    void updateSuccessStatusById(Integer positionId);

    List<PositionActiveListResponseDTO> queryActiveList();
}

