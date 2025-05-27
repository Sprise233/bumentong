package com.github.sprise233.bumentong.controller;

import com.github.sprise233.bumentong.dto.ListResponseDTO;
import com.github.sprise233.bumentong.dto.OperateLogDTO;
import com.github.sprise233.bumentong.dto.OperateLogParamsDTO;
import com.github.sprise233.bumentong.dto.ResultDTO;
import com.github.sprise233.bumentong.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RequestMapping("/log/page")
@RestController
public class OperateLogController {

    @Autowired
    OperateLogService operateLogService;

    @GetMapping
    public ResultDTO getOperateLog(OperateLogParamsDTO operateLogParamsDTO) {
        ListResponseDTO<OperateLogDTO> operateLogs = operateLogService.getOperateLogs(operateLogParamsDTO);
        return ResultDTO.ok(operateLogs);
    }

}
