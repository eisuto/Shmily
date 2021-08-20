package com.poi.adminuser.controller;

import java.sql.ResultSet;
import java.util.List;

import com.github.pagehelper.PageHelper;
import com.poi.adminuser.service.AdminRoleService;
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
import com.poi.domain.ShyRole;


/**
 * 角色Controller
 *
 * @author WangXiang
 * @date 2021-08-12
 */
@RestController
@RequestMapping("/admin/role")
public class AdminRoleController {
    @Autowired
    AdminRoleService adminRoleService;

    /**
     * 查询角色的权限
     */
    @PostMapping("/comps")
    public Result comps(@RequestBody ShyRole form){
        return Result.success(adminRoleService.comps(form));
    }

    /**
     * 保存角色权限
     */
    @PostMapping("/saveComps")
    public Result saveComps(@RequestBody ShyRole form){
        return Result.success(adminRoleService.saveComps(form));
    }

    /**
     * 查询角色列表
     */
    @PostMapping("/list")
    public Result list(@RequestBody  ShyRole shyRole) {
        PageHelper.startPage(shyRole.getPageNum(), shyRole.getPageSize());
        List<ShyRole> list = adminRoleService.selectShyRoleList(shyRole);
        return Result.success(new ResultVo(list));
    }


    /**
     * 获取角色详细信息
     */
    @GetMapping(value = "/{id}")
    public Result getInfo(@PathVariable("id") Long id) {
        return Result.success(adminRoleService.selectShyRoleById(id));
    }

    /**
     * 新增角色
     */
    @PostMapping
    public Result add(@RequestBody ShyRole shyRole) {
        return Result.success(adminRoleService.insertShyRole(shyRole));
    }

    /**
     * 修改角色
     */
    @PutMapping
    public Result edit(@RequestBody ShyRole shyRole) {
        return Result.success(adminRoleService.updateShyRole(shyRole));
    }

    /**
     * 删除角色
     */
    @DeleteMapping("/{ids}")
    public Result remove(@PathVariable Long[] ids) {
        return Result.success(adminRoleService.deleteShyRoleByIds(ids));
    }
}
