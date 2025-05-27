package com.github.sprise233.bumentong.controller;

import com.github.sprise233.bumentong.anno.Log;
import com.github.sprise233.bumentong.dto.EmployeeDTO;
import com.github.sprise233.bumentong.dto.EmployeeParamsDTO;
import com.github.sprise233.bumentong.entity.Employee;
import com.github.sprise233.bumentong.service.EmployeeService;
import com.github.sprise233.bumentong.dto.ResultDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@RequestMapping("/emps")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

//    /**
//     * 查询所有员工
//     */
//    @GetMapping
//    public ResultDTO getAllEmployees() {
//        List<Employee> employees = employeeService.getAllEmployees();
//        return ResultDTO.ok(employees);
//    }

    /**
     * 根据条件查询员工信息
     */
    @Log
    @GetMapping
    public ResultDTO getEmployees(EmployeeParamsDTO employeeParamsDTO) {
        return ResultDTO.ok(employeeService.getEmployeesByQueryParams(employeeParamsDTO));
    }

    /**
     * 根据ID查询员工信息
     */
    @Log
    @GetMapping("/{id}")
    public ResultDTO getEmployeeById(@PathVariable Integer id) {
        EmployeeDTO employeeDTO = employeeService.getEmployeeById(id);
        return ResultDTO.ok(employeeDTO);
    }

    /**
     * 新增员工
     */
    @Log
    @PostMapping
    public ResultDTO addEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.addEmployee(employeeDTO);
        return ResultDTO.ok("新增成功");
    }

    /**
     * 更新员工信息
     */
    @Log
    @PutMapping
    public ResultDTO updateEmployee(@RequestBody EmployeeDTO employeeDTO) {
        employeeService.updateEmployee(employeeDTO);
        return ResultDTO.ok("更新成功");
    }

    /**
     * 删除员工
     */
    @Log
    @DeleteMapping("/{id}")
    public ResultDTO deleteEmployeeById(@PathVariable Integer id) {
        employeeService.deleteEmployeeById(id);
        return ResultDTO.ok("删除成功");
    }

    @Log
    @DeleteMapping
    public ResultDTO deleteEmployeeByIds(@RequestParam Integer[] ids) {
        employeeService.deleteEmployeeByIds(ids);
        return ResultDTO.ok("删除成功");
    }
}
