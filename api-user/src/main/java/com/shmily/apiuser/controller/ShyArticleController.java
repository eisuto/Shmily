package com.shmily.apiuser.controller;


import com.poi.base.Result;
import com.poi.domain.ShyArticle;
import com.poi.domain.ShyUser;
import com.shmily.apiuser.service.ShyArticleService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.ResultSet;

/**
 * 推文服务 【重要】
 * @author eisuto
 */
@RestController
@RequestMapping("/api/article")
public class ShyArticleController {

    ShyArticleService articleService;

    public ShyArticleController(ShyArticleService articleService) {
        this.articleService = articleService;
    }

    /**
     * 点赞
     * @param article
     * @return
     * @throws Exception
     */
    @PostMapping("/like")
    public Result like(ShyArticle article) throws Exception {
        return Result.success(articleService.like(article));
    }

    /**
     * 发推
     *
     * @param article 推文
     * @return 信息
     * @throws Exception 错误信息
     */
    @PostMapping("/send")
    public Result send(ShyArticle article) throws Exception {
        return Result.success(articleService.send(article));
    }

    /**
     * 查看关注者的推文
     * @param user 用户
     * @return 推文列表
     * @throws Exception 错误信息
     */
    @PostMapping("/follows")
    public Result follow(ShyUser user) throws Exception{
        return Result.success(articleService.follows(user));
    }
}
