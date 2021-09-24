package com.shmily.cos.service;

import com.qcloud.cos.COSClient;
import com.qcloud.cos.ClientConfig;
import com.qcloud.cos.auth.BasicCOSCredentials;
import com.qcloud.cos.auth.COSCredentials;
import com.qcloud.cos.model.PutObjectRequest;
import com.qcloud.cos.region.Region;
import com.shmily.cos.config.CosConfig;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;
import java.util.UUID;

@Service
public class CosServiceImpl implements CosService{
    @Autowired
    CosConfig cosConfig;

    private static final Logger LOG = LoggerFactory.getLogger(CosServiceImpl.class);

    @Override
    public List<String> upload(MultipartFile[] files) throws Exception{
        List<String> paths = new ArrayList<>(files.length);
        for (MultipartFile file : files) {
            String oldFileName = file.getOriginalFilename();
            assert oldFileName != null;
            String eName = oldFileName.substring(oldFileName.lastIndexOf("."));
            String newFileName = UUID.randomUUID() + eName;
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DATE);
            // 1 初始化用户身份信息(secretId, secretKey)
            COSCredentials cred = new BasicCOSCredentials(cosConfig.accessKey, cosConfig.secretKey);
            // 2 设置bucket的区域, COS地域的简称请参照 https://cloud.tencent.com/document/product/436/6224
            com.qcloud.cos.ClientConfig clientConfig = new ClientConfig(new Region(cosConfig.bucket));
            // 3 生成cos客户端
            COSClient cosclient = new COSClient(cred, clientConfig);
            // bucket的命名规则为{name}-{appid} ，此处填写的存储桶名称必须为此格式
            String bucketName = cosConfig.bucketName;

            // 简单文件上传, 最大支持 5 GB, 适用于小文件上传, 建议 20 M 以下的文件使用该接口
            // 大文件上传请参照 API 文档高级 API 上传
            File localFile;
            try {
                localFile = File.createTempFile("temp", null);
                file.transferTo(localFile);
                // 指定要上传到 COS 上的路径
                String key = "/" + cosConfig.qianzui + "/" + year + "/" +
                        month + "/" + day + "/" + newFileName;
                PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, key, localFile);
                cosclient.putObject(putObjectRequest);
                String path = cosConfig.path + putObjectRequest.getKey();
                LOG.info(String.format("文件【%s】上传成功，路径为：%s", newFileName,path));
                paths.add(path);
            } catch (IOException e) {
                throw new Exception(e);
            } finally {
                // 关闭上传进程
                cosclient.shutdown();
            }
        }
        return paths;
    }
}