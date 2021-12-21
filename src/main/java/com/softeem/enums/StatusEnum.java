package com.softeem.enums;

/**
 * @author panpan@softeem.com
 * @description 员工状态枚举类
 * @since 2021/10/25 20:40
 */
public enum StatusEnum {

    ONJOB(1,"在职"),RESIGN(0,"离职");

    private Integer status;

    private String statusName;

    StatusEnum(Integer status, String statusName) {
        this.status = status;
        this.statusName = statusName;
    }

    public Integer getStatus(){
        return status;
    }

    public String getStatusName() {
        return statusName;
    }

    public static StatusEnum stateOf(Integer status) {
        for (StatusEnum statusEnum : values()) {
            if (statusEnum.getStatus().equals(status)) {
                return statusEnum;
            }
        }
        return null;
    }

}
