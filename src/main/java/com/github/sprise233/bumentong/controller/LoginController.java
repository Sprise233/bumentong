package com.github.sprise233.bumentong.controller;

import com.github.sprise233.bumentong.dto.LoginDTO;
import com.github.sprise233.bumentong.dto.LoginParamsDTO;
import com.github.sprise233.bumentong.dto.ResultDTO;
import com.github.sprise233.bumentong.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/login")
public class LoginController {

    @Autowired
    LoginService loginService;
    
    @PostMapping
    public ResultDTO login(@RequestBody LoginParamsDTO loginParamsDTO) {
        LoginDTO loginDTO = loginService.login(loginParamsDTO);
        if (loginDTO == null) {
            return ResultDTO.error("用户名或密码错误");
        }
        return ResultDTO.ok(loginDTO);
    }
}
