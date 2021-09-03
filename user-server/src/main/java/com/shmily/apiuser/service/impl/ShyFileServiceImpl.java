package com.shmily.apiuser.service.impl;

import com.poi.base.TempCache;
import com.poi.uitls.DateUtils;
import com.shmily.apiuser.config.GlobalExceptionAdvice;
import com.shmily.apiuser.config.ValueConfig;
import com.shmily.apiuser.service.ShyFileService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.util.DigestUtils;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class ShyFileServiceImpl implements ShyFileService {
    private static final Logger LOG = LoggerFactory.getLogger(GlobalExceptionAdvice.class);

    @Autowired
    ValueConfig valueConfig;

    /**
     * 上传文件
     */
    @Override
    public List<String> upload(MultipartFile[] files) throws Exception {
        List<String> paths = new ArrayList<>(files.length);
        for (MultipartFile file : files) {
            String allName = file.getOriginalFilename();
            String fileName = allName;
            allName = DigestUtils.md5DigestAsHex(allName.getBytes());
            String allPath = valueConfig.nginxPath + "/img/" + DateUtils.datePath() + '/' + allName + fileName;
            String url = "/img/" + DateUtils.datePath() + '/' + allName + fileName;
            File dest = new File(allPath);
            if (!dest.getParentFile().exists()) {
                dest.getParentFile().mkdirs();
            }
            try {
                file.transferTo(dest);
                LOG.info(String.format("文件【%s】上传成功", allName));
                paths.add(url);
            } catch (Exception e) {
                LOG.error(String.format("文件【%s】上传错误", allName));
                throw e;
            }
        }
        return paths;
    }
}
