package com.github.sprise233.bumentong.mapper;

import com.github.sprise233.bumentong.dto.OperateLogDTO;
import com.github.sprise233.bumentong.dto.OperateLogParamsDTO;
import com.github.sprise233.bumentong.entity.OperateLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface OperateLogMapper {

    void insertOperateLog(OperateLog operateLog);

    List<OperateLogDTO> getOperateByParams(OperateLogParamsDTO operateLogParamsDTO);
}
