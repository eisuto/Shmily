package com.shmily.apiuser.controller;

import com.poi.base.Result;
import com.shmily.apiuser.service.ShyFileService;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
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
    @ApiOperation(value = "上传", notes = "手机号、邮箱、用户名均可")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "files", value = "1", required = true),
    })
    @RequestMapping("/upload")
    public Result upload(@RequestParam("files") MultipartFile[] files) throws Exception{
        return Result.success(fileService.upload(files));
    }
}
