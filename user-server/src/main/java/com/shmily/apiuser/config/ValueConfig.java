package com.shmily.apiuser.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ValueConfig {
    @Value("${nginx.path}")
    public String nginxPath;
}
