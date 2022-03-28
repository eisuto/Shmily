package com.shmily.search.controller;

import com.poi.base.Result;
import com.shmily.search.service.ShySearchService;

import javax.annotation.Resource;

/**
 * @author WangXiang
 * @date 2022/3/27 21:24
 */
public class ShySearchController {
    @Resource
    ShySearchService redisService;
    public Result contentSearch(String keyword){
        return Result.success(redisService.contentSearch(keyword));
    }
}
