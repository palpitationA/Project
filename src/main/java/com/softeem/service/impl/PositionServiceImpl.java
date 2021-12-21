package com.softeem.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.softeem.dao.PositionDao;
import com.softeem.dto.requestDTO.PositionListReqeustDTO;
import com.softeem.dto.requestDTO.TogglePositionRequestDTO;
import com.softeem.dto.responseDTO.PositionActiveListResponseDTO;
import com.softeem.dto.responseDTO.PositionListResponseDTO;
import com.softeem.entity.Position;
import com.softeem.service.PositionService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 职位表(Position)表服务实现类
 *
 * @author muzi
 * @since 2021-05-15 14:17:22
 */
@Service("positionService")
public class PositionServiceImpl implements PositionService {
    @Resource
    private PositionDao positionDao;

    /**
     * 通过ID查询单条数据
     *
     * @param positionId 主键
     * @return 实例对象
     */
    @Override
    public Position queryById(Integer positionId) {
        return this.positionDao.queryById(positionId);
    }

    /**
     * 查询多条数据
     *
     * @param offset 查询起始位置
     * @param limit  查询条数
     * @return 对象列表
     */
    @Override
    public List<Position> queryAllByLimit(int offset, int limit) {
        return this.positionDao.queryAllByLimit(offset, limit);
    }

    /**
     * 新增数据
     *
     * @param position 实例对象
     * @return 实例对象
     */
    @Override
    public Position insert(Position position) {
        this.positionDao.insert(position);
        return position;
    }

    /**
     * 修改数据
     *
     * @param position 实例对象
     * @return 实例对象
     */
    @Override
    public Position update(Position position) {
        this.positionDao.update(position);
        return this.queryById(position.getPositionId());
    }

    /**
     * 通过主键删除数据
     *
     * @param positionId 主键
     * @return 是否成功
     */
    @Override
    public boolean deleteById(Integer positionId) {
        return this.positionDao.deleteById(positionId) > 0;
    }

    @Override
    public Map<String, Object> queryByPageList(PositionListReqeustDTO reqeustDTO) {
        Map<String, Object> map = new HashMap<>();
        try {
            PageHelper.startPage(reqeustDTO.getPageNum(), reqeustDTO.getPageSize());
            Page<PositionListResponseDTO> positionList = (Page) positionDao.queryPageList(reqeustDTO);
            map.put("success", true);
            map.put("data", new PageInfo(positionList));
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("查询职位列表失败");
        }
        return map;
    }

    @Override
    public void toggleStatus(TogglePositionRequestDTO position) {
        Integer status = position.getStatus();
        if (1 == status) {
            positionDao.updateFailureStatusById(position.getPositionId());
        } else {
            positionDao.updateSuccessStatusById(position.getPositionId());
        }
    }

    @Override
    public Map<String, Object> queryActiveList() {
        Map<String, Object> map = new HashMap<>();
        try {
            List<PositionActiveListResponseDTO> departmentList = positionDao.queryActiveList();
            map.put("success", true);
            map.put("data", departmentList);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("获取有效职位列表失败",e);
        }
        return map;
    }
}
