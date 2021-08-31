package com.shmily.apiuser.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface ShyFileService {
    /**
     * 上传文件
     * @return
     */
    List<String> upload(MultipartFile[] files) throws Exception;
}
