package com.shmily.apiuser.service;

import com.poi.domain.ShyArticle;

public interface ShyArticleService {
    /**
     * 发推服务
     *
     * @return 成功
     * @throws Exception 失败问题
     */
    int send(ShyArticle article) throws Exception;
}
