package com.github.sprise233.bumentong.service.Impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.sprise233.bumentong.dto.ListResponseDTO;
import com.github.sprise233.bumentong.dto.OperateLogDTO;
import com.github.sprise233.bumentong.dto.OperateLogParamsDTO;
import com.github.sprise233.bumentong.entity.OperateLog;
import com.github.sprise233.bumentong.mapper.OperateLogMapper;
import com.github.sprise233.bumentong.service.OperateLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OperateLogServiceImpl implements OperateLogService {

    @Autowired
    OperateLogMapper operateLogMapper;

    @Override
    public void insertOperateLog(OperateLog operateLog) {
        operateLogMapper.insertOperateLog(operateLog);
    }

    @Override
    public ListResponseDTO<OperateLogDTO> getOperateLogs(OperateLogParamsDTO operateLogParamsDTO) {
        PageHelper.startPage(operateLogParamsDTO.getPage(), operateLogParamsDTO.getPageSize());
        List<OperateLogDTO> operateLogDTOS = operateLogMapper.getOperateByParams(operateLogParamsDTO);
        Page<OperateLogDTO> page = (Page<OperateLogDTO>) operateLogDTOS;
        return new ListResponseDTO<>(page.getTotal(), page.getResult());
    }
}
