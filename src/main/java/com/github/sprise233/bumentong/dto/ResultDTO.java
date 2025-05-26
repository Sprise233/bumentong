package com.github.sprise233.bumentong.dto;

import lombok.Data;

@Data
public class ResultDTO {
    private String msg;
    private Object data;
    private Integer code;

    public static ResultDTO ok(Object data)
    {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setMsg("操作成功");
        resultDTO.setData(data);
        resultDTO.setCode(1);
        return resultDTO;
    }
    public static ResultDTO error(String msg)
    {
        ResultDTO resultDTO = new ResultDTO();
        resultDTO.setMsg(msg);
        resultDTO.setData(null);
        resultDTO.setCode(2);
        return resultDTO;
    }
}
