package com.github.sprise233.bumentong.service;

import com.github.sprise233.bumentong.dto.LoginDTO;
import com.github.sprise233.bumentong.dto.LoginParamsDTO;
import org.springframework.stereotype.Service;

public interface LoginService {
    LoginDTO login(LoginParamsDTO loginParamsDTO);
}
