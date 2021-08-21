package com.shmily.apiuser.service;

import com.poi.domain.ShyArticle;
import com.poi.domain.ShyUser;

import java.util.List;

public interface ShyArticleService {

    /**
     * 点赞
     * @return 成功
     * @throws Exception 失败问题
     */
    int like(ShyArticle article) throws Exception;

    /**
     * 发推服务
     *
     * @return 成功
     * @throws Exception 失败问题
     */
    int send(ShyArticle article) throws Exception;


    /**
     * 查询用户关注的所有人的推文
     * @param user 用户
     * @return 推文
     * @throws Exception 失败问题
     */
    List<ShyArticle> follows(ShyUser user) throws Exception;
}
