package com.github.sprise233.bumentong.controller;

import com.aliyuncs.exceptions.ClientException;
import com.github.sprise233.bumentong.dto.ResultDTO;
import com.github.sprise233.bumentong.service.UploadFileService;
import com.github.sprise233.bumentong.utils.AliOssUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/upload")
public class UploadController {

    @Autowired
    UploadFileService uploadFileService;

    @PostMapping
    public ResultDTO uploadFile(@RequestParam("file") MultipartFile multipartFile) throws Exception {
        String url = uploadFileService.uploadFile(multipartFile.getOriginalFilename(), multipartFile.getBytes());
        return ResultDTO.ok(url);
    }
}
