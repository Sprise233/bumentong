package com.github.sprise233.bumentong.controller;

import com.github.sprise233.bumentong.anno.Log;
import com.github.sprise233.bumentong.dto.ResultDTO;
import com.github.sprise233.bumentong.entity.Dept;
import com.github.sprise233.bumentong.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/depts")
@RestController
public class DeptController {

    @Autowired
    private DeptService deptService;

    @Log
    @GetMapping
    public ResultDTO getAllDepts(){
        return ResultDTO.ok(deptService.getAllDepts());
    }

    @Log
    @DeleteMapping
    public ResultDTO deleteDept(@RequestParam("id") Integer id){
        deptService.deleteDept(id);
        return ResultDTO.ok(null);
    }

    @Log
    @PostMapping
    public ResultDTO addDept(@RequestBody Dept dept){
        return ResultDTO.ok(deptService.addDept(dept)) ;
    }

    @Log
    @GetMapping("/{id:\\d+}")
    public ResultDTO getDept(@PathVariable("id") Integer id){
        return deptService.getDept(id);
    }

    @Log
    @PutMapping
    public ResultDTO updateDept(@RequestBody Dept dept){
        return deptService.updateDept(dept);
    }}