package com.github.sprise233.bumentong.entity;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class Employee {
    private Integer id; // 主键ID
    private String name; // 员工姓名
    private Integer gender; // 性别
    private String image; // 头像
    private String phone; // 手机号
    private Double salary; // 薪资
    private String password; // 密码
    private String position; // 职位
    private LocalDateTime entryDate; // 入职时间
    private Integer deptId; // 部门ID
    private LocalDateTime createTime; // 创建时间
    private LocalDateTime updateTime; // 修改时间
    private String username; // 用户名
}
