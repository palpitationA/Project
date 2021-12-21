package com.softeem.dto.responseDTO;

import com.softeem.dto.EmployeeDTO;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @author panpan@softeem.com
 * @description
 * @since 2021/10/25 20:22
 */
@Data
public class EmployeeResponseDTO implements Serializable {

    private static final long serialVersionUID = -1843411815628261476L;

    @ApiModelProperty(value = "员工信息")
    private EmployeeDTO employeeDTO;
    @ApiModelProperty(value = "部门下拉列表信息")
    private List<DepartmentActiveListResponseDTO> departmentList;
    @ApiModelProperty(value = "职位下拉列表信息")
    private List<PositionActiveListResponseDTO> positionList;


}
