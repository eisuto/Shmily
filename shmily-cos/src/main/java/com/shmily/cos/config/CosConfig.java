package com.shmily.cos.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@ConfigurationProperties(prefix = "tcos")
@Configuration
@Data
public class CosConfig {
    public String accessKey;
    public String secretKey;
    public String bucket;
    public String bucketName;
    public String path;
    public String qianzui;
}
