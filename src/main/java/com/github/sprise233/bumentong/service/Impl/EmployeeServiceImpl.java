package com.github.sprise233.bumentong.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.sprise233.bumentong.dto.EmployeeDTO;
import com.github.sprise233.bumentong.dto.EmployeeParamsDTO;
import com.github.sprise233.bumentong.dto.ListResponseDTO;
import com.github.sprise233.bumentong.dto.ResultDTO;
import com.github.sprise233.bumentong.entity.Employee;
import com.github.sprise233.bumentong.entity.EmployeeExpr;
import com.github.sprise233.bumentong.mapper.EmployeeExprMapper;
import com.github.sprise233.bumentong.mapper.EmployeeMapper;
import com.github.sprise233.bumentong.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class EmployeeServiceImpl implements EmployeeService {
    @Autowired
    private EmployeeMapper employeeMapper;

    @Autowired
    private EmployeeExprMapper employeeExprMapper;


    @Override
    public EmployeeDTO getEmployeeById(Integer id) {
        return employeeMapper.getEmployeeById(id);
    }

    @Override
    @Transactional
    public void addEmployee(EmployeeDTO employeeDTO) {
        employeeDTO.setCreateTime(LocalDateTime.now());
        employeeDTO.setUpdateTime(LocalDateTime.now());
        employeeMapper.addEmployee(employeeDTO);

        Integer generatedId = employeeDTO.getId();
        if (generatedId == null) {
            throw new RuntimeException("新增员工失败，获取主键ID失败");
        }
        employeeDTO.getExprList().forEach(expr -> expr.setEmployeeId(generatedId));

        employeeExprMapper.addEmployeeExpr(employeeDTO.getExprList());
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public void updateEmployee(EmployeeDTO employeeDTO) {
        employeeMapper.updateEmployee(employeeDTO);

        employeeExprMapper.deleteByEmployeeId(employeeDTO.getId());
        employeeDTO.getExprList().forEach(expr -> expr.setEmployeeId(employeeDTO.getId()));
        employeeExprMapper.addEmployeeExpr(employeeDTO.getExprList());
    }


    @Override
    public void deleteEmployeeById(Integer id) {
        employeeMapper.deleteEmployeeById(id);
    }

    @Override
    public ListResponseDTO<EmployeeDTO> getEmployeesByQueryParams(EmployeeParamsDTO employeeParamsDTO) {
        // 分页
        PageHelper.startPage(employeeParamsDTO.getPage(), employeeParamsDTO.getPageSize());
        List<EmployeeDTO> employees = employeeMapper.selectByQueryParams(employeeParamsDTO);
        Page<EmployeeDTO> page = (Page<EmployeeDTO>) employees;
        return new ListResponseDTO<>(page.getTotal(), page.getResult());
    }

    @Override
    public void deleteEmployeeByIds(Integer[] ids) {
        for (Integer id : ids) {
            employeeMapper.deleteEmployeeById(id);
        }
    }

}