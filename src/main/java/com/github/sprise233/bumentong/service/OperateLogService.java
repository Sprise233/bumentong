package com.github.sprise233.bumentong.service;

import com.github.sprise233.bumentong.dto.ListResponseDTO;
import com.github.sprise233.bumentong.dto.OperateLogDTO;
import com.github.sprise233.bumentong.dto.OperateLogParamsDTO;
import com.github.sprise233.bumentong.entity.OperateLog;

import java.util.List;

public interface OperateLogService {
    void insertOperateLog(OperateLog operateLog);

    ListResponseDTO<OperateLogDTO> getOperateLogs(OperateLogParamsDTO operateLogParamsDTO);
}
