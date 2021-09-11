package com.shmily.apiuser.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Configuration;

@Configuration
@RefreshScope
public class ValueConfig {
    @Value("${nginx.path}")
    public String nginxPath;
}
