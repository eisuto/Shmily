package com.poi.adminuser.service;

import java.util.List;

import com.poi.domain.ShyArticle;

/**
 * 推文Service接口
 *
 * @author WangXiang
 * @date 2021-08-13
 */
public interface AdminArticleService {
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
     * 批量删除推文
     *
     * @param ids 需要删除的推文ID
     * @return 结果
     */
    public int deleteShyArticleByIds(Integer[] ids);

    /**
     * 删除推文信息
     *
     * @param id 推文ID
     * @return 结果
     */
    public int deleteShyArticleById(Integer id);
}
