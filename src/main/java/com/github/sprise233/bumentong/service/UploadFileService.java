package com.github.sprise233.bumentong.service;

public interface UploadFileService {
    String uploadFile(String fileName, byte[] fileBytes) throws Exception;
}
