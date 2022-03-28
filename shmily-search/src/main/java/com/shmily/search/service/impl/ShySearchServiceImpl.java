package com.shmily.search.service.impl;

import com.poi.mapper.ShyArticleMapper;
import com.poi.uitls.StringUtils;
import com.shmily.search.service.RedisSearch;
import com.shmily.search.service.ShySearchService;

import javax.annotation.Resource;
import java.util.Objects;

/**
 * @author WangXiang
 * @date 2022/3/27 21:16
 */
public class ShySearchServiceImpl implements ShySearchService {

    @Resource
    ShyArticleMapper shyArticleMapper;



    /**
     * 内容全文搜索
     *
     * @param keyword
     * @return
     */
    @Override
    public String contentSearch(String keyword) {
        String res = RedisSearch.search(keyword);;
        if(StringUtils.isNotEmpty(res)){
            return res;
        }else{
            shyArticleMapper.selectShyArticleList(null);
        }
        return res;
    }
}
