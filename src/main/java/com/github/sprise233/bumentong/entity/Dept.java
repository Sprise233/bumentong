package com.github.sprise233.bumentong.entity;

import lombok.Data;

import java.time.LocalDateTime;
import java.util.Date;
import java.io.Serializable;

/**
 * 部门表(Dept)实体类
 *
 * @author makejava
 * @since 2025-05-21 19:31:02
 */
@Data
public class Dept {
    private Integer id;
    private String name;
    private LocalDateTime createTime;
    private LocalDateTime updateTime;
}

