package com.poi.base;

import java.util.HashMap;

public class TempCache {

    /**
     * 验证码缓存
     */
    public static HashMap<String,String> codeCacheMap = new HashMap<>();

    /**
     * 文件上传位置
     */
    public static String uploadFilePath = System.getProperty("user.dir");
}
