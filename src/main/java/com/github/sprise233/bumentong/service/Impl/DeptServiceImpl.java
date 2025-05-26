package com.github.sprise233.bumentong.service.Impl;

import com.github.sprise233.bumentong.dto.ResultDTO;
import com.github.sprise233.bumentong.entity.Dept;
import com.github.sprise233.bumentong.mapper.DeptMapper;
import com.github.sprise233.bumentong.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;

@Service
public class DeptServiceImpl implements DeptService {

    @Autowired
    private DeptMapper deptMapper;

    @Override
    public List<Dept> getAllDepts() {
        return deptMapper.getAllDept();
    }

    @Override
    public void deleteDept(Integer id) {
        deptMapper.deleteDeptById(id);
    }

    @Override
    public ResultDTO addDept(Dept dept) {
        dept.setCreateTime(LocalDateTime.now());
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.addDept(dept);
        return ResultDTO.ok(dept);
    }

    @Override
    public ResultDTO getDept(Integer id) {
        Dept dept = deptMapper.getDeptById(id);
        if (dept == null) {
            return ResultDTO.error("部门不存在");
        }
        return ResultDTO.ok(dept);
    }

    @Override
    public ResultDTO updateDept(Dept dept) {
        dept.setUpdateTime(LocalDateTime.now());
        deptMapper.updateDept(dept);
        return ResultDTO.ok(dept);
    }
}
