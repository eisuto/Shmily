package com.poi.adminuser.controller;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.poi.adminuser.service.AdminArticleService;
import com.poi.base.Result;
import com.poi.base.ResultVo;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.poi.domain.ShyArticle;

/**
 * 推文Controller
 * 
 * @author WangXiang
 * @date 2021-08-13
 */
@RestController
@RequestMapping("/admin/article")
public class AdminArticleController
{
    @Autowired
    AdminArticleService shyArticleService;

    /**
     * 查询推文列表
     */
    
    @PostMapping("/list")
    public Result list(@RequestBody ShyArticle shyArticle)
    {
        PageHelper.startPage(shyArticle.getPageNum(),shyArticle.getPageSize());
        List<ShyArticle> list = shyArticleService.selectShyArticleList(shyArticle);
        return Result.success(new ResultVo(list));
    }
    

    /**
     * 获取推文详细信息
     */
    
    @GetMapping(value = "/{id}")
    public Result getInfo( Integer id)
    {
        return Result.success(shyArticleService.selectShyArticleById(id));
    }

    /**
     * 新增推文
     */
    
    
    @PostMapping
    public Result add(@RequestBody ShyArticle shyArticle)
    {
        return Result.success(shyArticleService.insertShyArticle(shyArticle));
    }

    /**
     * 修改推文
     */
    
    
    @PutMapping
    public Result edit(@RequestBody ShyArticle shyArticle)
    {
        return Result.success(shyArticleService.updateShyArticle(shyArticle));
    }

    /**
     * 删除推文
     */
    
    
	@DeleteMapping("/{ids}")
    public Result remove(@PathVariable Integer[] ids)
    {
        return Result.success(shyArticleService.deleteShyArticleByIds(ids));
    }
}
