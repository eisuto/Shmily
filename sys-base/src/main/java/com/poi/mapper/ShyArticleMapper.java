package com.poi.mapper;

import java.util.List;
import com.poi.domain.ShyArticle;
import org.apache.ibatis.annotations.Mapper;

/**
 * 文章Mapper接口
 * 
 * @author WangXiang
 * @date 2021-08-13
 */
@Mapper
public interface ShyArticleMapper 
{
    /**
     * 查询文章
     * 
     * @param id 文章ID
     * @return 文章
     */
    public ShyArticle selectShyArticleById(Integer id);

    /**
     * 查询文章列表
     * 
     * @param shyArticle 文章
     * @return 文章集合
     */
    public List<ShyArticle> selectShyArticleList(ShyArticle shyArticle);

    /**
     * 新增文章
     * 
     * @param shyArticle 文章
     * @return 结果
     */
    public int insertShyArticle(ShyArticle shyArticle);

    /**
     * 修改文章
     * 
     * @param shyArticle 文章
     * @return 结果
     */
    public int updateShyArticle(ShyArticle shyArticle);

    /**
     * 删除文章
     * 
     * @param id 文章ID
     * @return 结果
     */
    public int deleteShyArticleById(Integer id);

    /**
     * 批量删除文章
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShyArticleByIds(Integer[] ids);
}
