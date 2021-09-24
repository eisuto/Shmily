package com.shmily.cos.controller;

import com.poi.base.Result;
import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;
import com.shmily.cos.config.CosConfig;
import com.shmily.cos.service.CosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.UUID;

/**
 * @author eisuto
 */
@Controller
@RequestMapping(value = "/api/cos")
public class UpLoadController {

    @Autowired
    CosService cosService;
    /**
     * 上传到腾讯云对象存储
     *
     * @return
     */
    @PostMapping(value = "/upload")
    @ResponseBody
    public Result upload(@RequestParam(value = "file") MultipartFile[] files) throws Exception {
        if (files == null) {
            return Result.error();
        }
        return Result.success(cosService.upload(files));

    }
}
