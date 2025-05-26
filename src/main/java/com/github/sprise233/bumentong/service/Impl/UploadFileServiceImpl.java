package com.github.sprise233.bumentong.service.Impl;

import com.github.sprise233.bumentong.service.UploadFileService;
import com.github.sprise233.bumentong.utils.AliOssUtils;
import org.springframework.stereotype.Service;

@Service
public class UploadFileServiceImpl implements UploadFileService {
    @Override
    public String uploadFile(String fileName, byte[] fileBytes) throws Exception {
        return AliOssUtils.uploadFile(fileName, fileBytes);
    }
}
