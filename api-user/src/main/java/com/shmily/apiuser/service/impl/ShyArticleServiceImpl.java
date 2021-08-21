package com.shmily.apiuser.service.impl;

import com.poi.domain.ShyArticle;
import com.poi.mapper.ShyArticleMapper;
import com.poi.uitls.DateUtils;
import com.shmily.apiuser.service.ShyArticleService;
import org.springframework.stereotype.Service;

@Service
public class ShyArticleServiceImpl implements ShyArticleService {

    ShyArticleMapper articleMapper;

    public ShyArticleServiceImpl(ShyArticleMapper articleMapper) {
        this.articleMapper = articleMapper;
    }

    /**
     * 发推服务
     *
     * @param article 推文
     * @return 成功
     * @throws Exception 失败问题
     */
    @Override
    public int send(ShyArticle article) throws Exception {

        article.setCreateTime(DateUtils.getNowDate());
        return articleMapper.insertShyArticle(article);
    }
}
