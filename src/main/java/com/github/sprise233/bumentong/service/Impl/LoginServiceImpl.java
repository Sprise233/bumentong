package com.github.sprise233.bumentong.service.Impl;

import com.github.sprise233.bumentong.dto.EmployeeDTO;
import com.github.sprise233.bumentong.dto.LoginDTO;
import com.github.sprise233.bumentong.dto.LoginParamsDTO;
import com.github.sprise233.bumentong.mapper.LoginMapper;
import com.github.sprise233.bumentong.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.github.sprise233.bumentong.utils.JWTUtils;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService {

    @Autowired
    LoginMapper loginMapper;

    @Override
    public LoginDTO login(LoginParamsDTO loginParamsDTO) {
        EmployeeDTO employeeDTO = loginMapper.login(loginParamsDTO);
        if (employeeDTO != null) {
            Map<String, Object> claims = new HashMap<>();
            claims.put("username", employeeDTO.getUsername());
            claims.put("id", employeeDTO.getId());
            String token = JWTUtils.generateToken(employeeDTO.getUsername(), claims);
            return new LoginDTO(employeeDTO.getId(), employeeDTO.getName(), employeeDTO.getUsername(), token);
        }
        return null;
    }
}
