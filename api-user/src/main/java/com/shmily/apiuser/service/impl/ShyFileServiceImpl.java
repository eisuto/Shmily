package com.shmily.apiuser.service.impl;

import com.poi.base.TempCache;
import com.poi.uitls.DateUtils;
import com.shmily.apiuser.config.GlobalExceptionAdvice;
import com.shmily.apiuser.service.ShyFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

@Service
public class ShyFileServiceImpl implements ShyFileService {
    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionAdvice.class);

    /**
     * 上传文件
     */
    @Override
    public List<String> upload(MultipartFile[] files) throws Exception {
        List<String> paths = new ArrayList<>(files.length);
        for (MultipartFile file : files) {
            String fileName = file.getOriginalFilename();
            String path = TempCache.uploadFilePath + DateUtils.datePath() + '/' + fileName;
            File dest = new File(path);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
                LOG.error(String.format("文件【%s】上传成功", fileName));
                paths.add(path);
            } catch (Exception e) {
                LOG.error(String.format("文件【%s】上传错误", fileName));
                throw e;
            }
        }
        return paths;
    }
}
