package com.github.sprise233.bumentong.service;


import com.github.sprise233.bumentong.dto.ResultDTO;
import com.github.sprise233.bumentong.entity.Dept;

import java.util.List;

public interface DeptService {

    void deleteDept(Integer id);

    ResultDTO addDept(Dept dept);

    ResultDTO getDept(Integer id);

    ResultDTO updateDept(Dept dept);

    List<Dept> getAllDepts();
}
