package com.github.sprise233.bumentong.mapper;

import com.github.sprise233.bumentong.dto.EmployeeDTO;
import com.github.sprise233.bumentong.dto.LoginParamsDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface LoginMapper {

    EmployeeDTO login(LoginParamsDTO loginParamsDTO);
}
