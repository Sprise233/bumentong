package com.github.sprise233.bumentong.mapper;

import com.github.sprise233.bumentong.entity.EmployeeExpr;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface EmployeeExprMapper {

    void addEmployeeExpr(List<EmployeeExpr> employeeExpr);


    void deleteByEmployeeId(Integer id);
}
