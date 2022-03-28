package com.shmily.apiuser.controller;

import com.poi.base.Result;
import com.shmily.apiuser.service.ShyFileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("/api/file")
public class ShyFileController {
    @Autowired
    ShyFileService fileService;

    /**
     * 图片上传
     * @param files
     * @return
     * @throws Exception
     */
    @RequestMapping("/upload")
    public Result upload(@RequestParam("file") MultipartFile[] files ) throws Exception{
        return Result.success(fileService.upload(files));
    }
}
