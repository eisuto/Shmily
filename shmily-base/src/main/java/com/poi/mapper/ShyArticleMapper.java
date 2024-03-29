package com.poi.mapper;

import java.util.List;

import com.poi.domain.ShyArticle;
import com.poi.domain.ShyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

/**
 * 推文Mapper接口
 *
 * @author WangXiang
 * @date 2021-08-13
 */
@Mapper
public interface ShyArticleMapper {

    /**
     * 推文图片列表
     * @param id
     * @return
     */
    public List<String> imgList(@Param("id") Integer id);

    /**
     * 保存图片地址
     *
     * @return
     */
    public int insertImage(@Param("id") Integer id, @Param("imgUrl") String imgUrl);

    /**
     * 获取一个推文的全部评论
     *
     * @return
     */
    public List<ShyArticle> comments(ShyArticle article);


    /**
     * 查询用户 点赞/评论/转发过的推文列表
     *
     * @param user
     * @return
     */
    public List<ShyArticle> operateByUser(ShyUser user);

    /**
     * 取消点赞
     *
     * @param article
     */
    public int unLike(ShyArticle article);

    /**
     * 推文操作 点赞/评论/转发
     *
     * @param articleId 微博id
     * @param userId    操作用户id
     * @param type      类型
     * @param comment   评论值
     * @return
     */
    public int operate(
            @Param("articleId") Integer articleId,
            @Param("userId") Integer userId,
            @Param("type") String type,
            @Param("comment") String comment
    );

    /**
     * 查询 用户关注者的推文列表
     *
     * @return 推文集合
     */
    public List<ShyArticle> selectFollows(ShyUser user);

    /**
     * 查询推文
     *
     * @param id 推文ID
     * @return 推文
     */
    public ShyArticle selectShyArticleById(Integer id);

    /**
     * 查询推文列表
     *
     * @param shyArticle 推文
     * @return 推文集合
     */
    public List<ShyArticle> selectShyArticleList(ShyArticle shyArticle);

    /**
     * 新增推文
     *
     * @param shyArticle 推文
     * @return 结果
     */
    public int insertShyArticle(ShyArticle shyArticle);

    /**
     * 修改推文
     *
     * @param shyArticle 推文
     * @return 结果
     */
    public int updateShyArticle(ShyArticle shyArticle);

    /**
     * 删除推文
     *
     * @param id 推文ID
     * @return 结果
     */
    public int deleteShyArticleById(Integer id);

    /**
     * 批量删除推文
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShyArticleByIds(Integer[] ids);
}
