package com.shmily.cos.service;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public interface CosService {
    /**
     * 上传到腾讯云对象存储
     * @param files
     * @return
     * @throws Exception
     */
    public List<String> upload(MultipartFile[] files) throws Exception;
}
