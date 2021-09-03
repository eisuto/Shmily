package com.shmily.apiuser.service.impl;

import com.poi.domain.ShyArticle;
import com.poi.domain.ShyUser;
import com.poi.mapper.ShyArticleMapper;
import com.poi.mapper.ShyUserMapper;
import com.poi.uitls.DateUtils;
import com.poi.uitls.StringUtils;
import com.shmily.apiuser.service.ShyArticleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Service
public class ShyArticleServiceImpl implements ShyArticleService {

    @Autowired
    ShyArticleMapper articleMapper;

    @Autowired
    ShyUserMapper shyUserMapper;


    /**
     * 获取一个推文的全部评论
     *
     * @param article
     * @return
     * @throws Exception
     */
    @Override
    public List<ShyArticle> comments(ShyArticle article) throws Exception {
        return articleMapper.comments(article);
    }

    /**
     * 评论
     *
     * @param article
     * @return 成功
     * @throws Exception 失败问题
     */
    @Override
    public int comment(ShyArticle article) throws Exception {
        ShyArticle articleOld = articleMapper.selectShyArticleById(article.getId());
        int commentNum = articleOld.getCommentNum();
        articleOld.setCommentNum(++commentNum);
        articleMapper.updateShyArticle(articleOld);
        return articleMapper.operate(article.getId(), article.getUserId(), "comment", article.getComment());
    }

    /**
     * 取消点赞
     *
     * @param article
     * @return 成功
     * @throws Exception 失败问题
     */
    @Override
    public int unLike(ShyArticle article) throws Exception {
        ShyArticle articleOld = articleMapper.selectShyArticleById(article.getId());
        int likeNum = articleOld.getLoveNum();
        articleOld.setLoveNum(--likeNum);
        articleMapper.updateShyArticle(articleOld);
        return articleMapper.unLike(article);
    }

    /**
     * 点赞
     *
     * @param article
     * @return 成功
     * @throws Exception 失败问题
     */
    @Override
    public int like(ShyArticle article) {
        ShyArticle articleOld = articleMapper.selectShyArticleById(article.getId());
        int likeNum = articleOld.getLoveNum();
        articleOld.setLoveNum(++likeNum);
        articleMapper.updateShyArticle(articleOld);
        return articleMapper.operate(article.getId(), article.getUserId(), "like", "");
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
        articleMapper.insertShyArticle(article);
        // 保存图片
        if(StringUtils.isNotEmpty(article.getUploadImgUrls())) {
            for (String imgUrl : article.getUploadImgUrls()) {
                articleMapper.insertImage(article.getId(), imgUrl);
            }
        }
        return 1;
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
        // 有关的推文
        List<ShyArticle> articles = articleMapper.selectFollows(user);
        articles.removeAll(Collections.singleton(null));

        // 此用户操作过的推文，着色
        List<ShyArticle> operates = articleMapper.operateByUser(user);

        user.setImgQuery(true);
        // 有关的推文图片
        List<ShyArticle> imgs = articleMapper.selectFollows(user);

        for (ShyArticle article : articles) {
            for (ShyArticle img : imgs) {
                if(article.getId().equals(img.getId())){
                    List<String> urls = article.getImgUrls();
                    if(urls == null){
                        urls = new ArrayList<>();
                    }
                    urls.add(img.getUrl());
                    article.setImgUrls(urls);
                }
            }
            for (ShyArticle operate : operates) {
                if (article.getId().equals(operate.getId())) {
                    if (StringUtils.equals(operate.getType(), "like")) {
                        article.setLiked(1);
                    }
                    if (StringUtils.equals(operate.getType(), "comment")) {
                        article.setCommented(1);
                    }
                    if (StringUtils.equals(operate.getType(), "tran")) {
                        article.setTraned(1);
                    }
                }
            }
        }


        return articles;
    }
}
