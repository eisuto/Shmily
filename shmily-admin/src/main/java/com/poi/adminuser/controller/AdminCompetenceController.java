package com.poi.adminuser.controller;

import java.util.List;

import com.github.pagehelper.PageHelper;
import com.poi.adminuser.service.AdminCompetenceService;
import com.poi.base.Result;
import com.poi.base.ResultVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.poi.domain.ShyCompetence;

/**
 * 权限Controller
 *
 * @author WangXiang
 * @date 2021-08-14
 */
@RestController
@RequestMapping("/admin/competence")
public class AdminCompetenceController {
    @Autowired
    private AdminCompetenceService adminCompetenceService;



    /**
     * 获取权限树型结构
     */
    @PostMapping("/tree")
    public Result tree() {
        return Result.success(adminCompetenceService.selectShyCompetenceTree());
    }

    /**
     * 查询权限列表
     */

    @PostMapping("/list")
    public Result list(@RequestBody ShyCompetence shyCompetence) {
        PageHelper.startPage(shyCompetence.getPageNum(), shyCompetence.getPageSize());
        List<ShyCompetence> list = adminCompetenceService.selectShyCompetenceList(shyCompetence);
        return Result.success(new ResultVo(list));
    }


    /**
     * 获取权限详细信息
     */

    @GetMapping(value = "/{id}")
    public Result getInfo(@PathVariable("id") Integer id) {
        return Result.success(adminCompetenceService.selectShyCompetenceById(id));
    }

    /**
     * 新增权限
     */


    @PostMapping
    public Result add(@RequestBody ShyCompetence shyCompetence) {
        return Result.success(adminCompetenceService.insertShyCompetence(shyCompetence));
    }

    /**
     * 修改权限
     */


    @PutMapping
    public Result edit(@RequestBody ShyCompetence shyCompetence) {
        return Result.success(adminCompetenceService.updateShyCompetence(shyCompetence));
    }

    /**
     * 删除权限
     */


    @DeleteMapping("/{ids}")
    public Result remove(@PathVariable Integer[] ids) {
        return Result.success(adminCompetenceService.deleteShyCompetenceByIds(ids));
    }
}
