package com.github.sprise233.bumentong.mapper;

import com.github.sprise233.bumentong.dto.EmployeeDTO;
import com.github.sprise233.bumentong.dto.EmployeeParamsDTO;
import com.github.sprise233.bumentong.entity.Employee;
import com.github.sprise233.bumentong.entity.EmployeeExpr;
import org.apache.ibatis.annotations.*;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface EmployeeMapper {

    /**
     * 根据ID查询员工信息
     */
    EmployeeDTO getEmployeeById(Integer id);

    /**
     * 新增员工
     */
    void addEmployee(EmployeeDTO employeeDTO);

    /**
     * 更新员工信息
     */
    void updateEmployee(EmployeeDTO employeeDTO);

    /**
     * 删除员工
     */
    void deleteEmployeeById(Integer id);

    /**
     * 根据查询参数查询员工列表
     */
    List<EmployeeDTO> selectByQueryParams(EmployeeParamsDTO employeeParamsDTO);
}