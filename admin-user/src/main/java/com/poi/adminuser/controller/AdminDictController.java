package com.poi.adminuser.controller;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.poi.adminuser.service.AdminDictService;
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
import com.poi.domain.ShyDict;


/**
 * 字典Controller
 * 
 * @author WangXiang
 * @date 2021-08-13
 */
@RestController
@RequestMapping("/admin/dict")
public class AdminDictController
{
    @Autowired
    AdminDictService shyDictService;

    /**
     * 查询字典列表
     */
    
    @PostMapping("/list")
    public Result list(@RequestBody ShyDict shyDict)
    {
        PageHelper.startPage(shyDict.getPageNum(), shyDict.getPageSize());
        List<ShyDict> list = shyDictService.selectShyDictList(shyDict);
        return Result.success(new ResultVo(list));
    }

    /**
     * 获取字典详细信息
     */
    
    @GetMapping(value = "/{id}")
    public Result getInfo(@PathVariable("id") Integer id)
    {
        return Result.success(shyDictService.selectShyDictById(id));
    }

    /**
     * 新增字典
     */
    
    
    @PostMapping
    public Result add(@RequestBody ShyDict shyDict)
    {
        return Result.success(shyDictService.insertShyDict(shyDict));
    }

    /**
     * 修改字典
     */
    
    
    @PutMapping
    public Result edit(@RequestBody ShyDict shyDict)
    {
        return Result.success(shyDictService.updateShyDict(shyDict));
    }

    /**
     * 删除字典
     */
    
    
	@DeleteMapping("/{ids}")
    public Result remove(@PathVariable Integer[] ids)
    {
        return Result.success(shyDictService.deleteShyDictByIds(ids));
    }
}
