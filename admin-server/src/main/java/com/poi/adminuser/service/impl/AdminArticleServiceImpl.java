package com.poi.adminuser.service.impl;

import java.util.List;

import com.poi.adminuser.service.AdminArticleService;
import com.poi.mapper.ShyArticleMapper;
import com.poi.uitls.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.poi.domain.ShyArticle;

/**
 * 推文Service业务层处理
 * 
 * @author WangXiang
 * @date 2021-08-13
 */
@Service
public class AdminArticleServiceImpl implements AdminArticleService
{
    @Autowired
    ShyArticleMapper shyArticleMapper;

    /**
     * 查询推文
     * 
     * @param id 推文ID
     * @return 推文
     */
    @Override
    public ShyArticle selectShyArticleById(Integer id)
    {
        return shyArticleMapper.selectShyArticleById(id);
    }

    /**
     * 查询推文列表
     * 
     * @param shyArticle 推文
     * @return 推文
     */
    @Override
    public List<ShyArticle> selectShyArticleList(ShyArticle shyArticle)
    {
        return shyArticleMapper.selectShyArticleList(shyArticle);
    }

    /**
     * 新增推文
     * 
     * @param shyArticle 推文
     * @return 结果
     */
    @Override
    public int insertShyArticle(ShyArticle shyArticle)
    {
        shyArticle.setCreateTime(DateUtils.getNowDate());
        return shyArticleMapper.insertShyArticle(shyArticle);
    }

    /**
     * 修改推文
     * 
     * @param shyArticle 推文
     * @return 结果
     */
    @Override
    public int updateShyArticle(ShyArticle shyArticle)
    {
        return shyArticleMapper.updateShyArticle(shyArticle);
    }

    /**
     * 批量删除推文
     * 
     * @param ids 需要删除的推文ID
     * @return 结果
     */
    @Override
    public int deleteShyArticleByIds(Integer[] ids)
    {
        return shyArticleMapper.deleteShyArticleByIds(ids);
    }

    /**
     * 删除推文信息
     * 
     * @param id 推文ID
     * @return 结果
     */
    @Override
    public int deleteShyArticleById(Integer id)
    {
        return shyArticleMapper.deleteShyArticleById(id);
    }
}
