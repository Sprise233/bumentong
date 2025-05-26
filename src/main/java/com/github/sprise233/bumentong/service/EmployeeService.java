package com.github.sprise233.bumentong.service;

import com.github.sprise233.bumentong.dto.EmployeeDTO;
import com.github.sprise233.bumentong.dto.EmployeeParamsDTO;
import com.github.sprise233.bumentong.dto.ListResponseDTO;
import com.github.sprise233.bumentong.dto.ResultDTO;
import com.github.sprise233.bumentong.entity.Employee;

import java.time.LocalDateTime;
import java.util.List;

public interface EmployeeService {

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
    ListResponseDTO<EmployeeDTO> getEmployeesByQueryParams(EmployeeParamsDTO employeeParamsDTO);

    void deleteEmployeeByIds(Integer[] ids);
}