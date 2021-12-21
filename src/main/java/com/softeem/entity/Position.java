package com.softeem.entity;

import lombok.Data;

import java.util.Date;
import java.io.Serializable;

/**
 * 职位表(Position)实体类
 *
 * @author panpan
 * @since 2021-10-15 14:17:22
 */
@Data
public class Position implements Serializable {
    private static final long serialVersionUID = 718164366046945752L;
    /**
     * 职位表id
     */
    private Integer positionId;
    /**
     * 职位名
     */
    private String positionName;
    /**
     * 创建时间
     */
    private Date createTime;
    /**
     * 状态 1:有效 0:无效
     */
    private Integer status;


    public Integer getPositionId() {
        return positionId;
    }

    public void setPositionId(Integer positionId) {
        this.positionId = positionId;
    }

    public String getPositionName() {
        return positionName;
    }

    public void setPositionName(String positionName) {
        this.positionName = positionName;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

}
