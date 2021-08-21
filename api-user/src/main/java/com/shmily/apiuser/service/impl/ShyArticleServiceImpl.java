package com.shmily.apiuser.service.impl;

import com.poi.domain.ShyArticle;
import com.poi.domain.ShyUser;
import com.poi.mapper.ShyArticleMapper;
import com.poi.mapper.ShyUserMapper;
import com.poi.uitls.DateUtils;
import com.shmily.apiuser.service.ShyArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShyArticleServiceImpl implements ShyArticleService {

    @Autowired
    ShyArticleMapper articleMapper;

    @Autowired
    ShyUserMapper shyUserMapper;


    /**
     * 点赞
     *
     * @param article
     * @return 成功
     * @throws Exception 失败问题
     */
    @Override
    public int like(ShyArticle article){
        ShyArticle articleOld = articleMapper.selectShyArticleById(article.getId());
        int likeNum = articleOld.getLoveNum();
        articleOld.setLoveNum(++likeNum);
        articleMapper.updateShyArticle(articleOld);
        return articleMapper.operate(article.getId(),article.getUserId(),"like","");
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

    /**
     * 查询用户关注的所有人的推文
     *
     * @param user 用户
     * @return 推文
     * @throws Exception 失败问题
     */
    @Override
    public List<ShyArticle> follows(ShyUser user) throws Exception {
        return articleMapper.selectFollows(user);
    }
}
