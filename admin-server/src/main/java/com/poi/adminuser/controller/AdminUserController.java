package com.poi.adminuser.controller;

import com.github.pagehelper.PageHelper;
import com.poi.adminuser.service.AdminUserService;
import com.poi.base.Result;
import com.poi.base.ResultVo;
import com.poi.domain.ShyUser;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

;

/**
 * admin 用户Controller
 *
 * @author eisuto
 * @date 07-14
 */
@Api(tags = "管理端用户服务")
@RestController
@RequestMapping("/admin/user")
public class AdminUserController {
    @Autowired
    private AdminUserService adminUserService;


    /**
     * 管理员登录
     */
    @PostMapping("/login")
    public Result login(@RequestBody ShyUser user) throws Exception {
        ShyUser shyUser = adminUserService.login(user);
        if(shyUser == null){
            return Result.error("用户名或密码错误");
        }
        shyUser.setPassword(null);
        return Result.success(shyUser);
    }

    /**
     * 查询用户列表
     */
    @ApiOperation(value = "查询用户列表")
    @PostMapping("/list")
    public Result list(@RequestBody ShyUser shyUser) {
        PageHelper.startPage(shyUser.getPageNum(), shyUser.getPageSize());
        List<ShyUser> list = adminUserService.selectShyUserList(shyUser);
        return Result.success(new ResultVo(list));
    }


    /**
     * 获取用户详细信息
     */
    @ApiOperation(value = "获取用户详细信息", notes = "用户信息")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "id", value = "id", required = true),
    })
    @GetMapping(value = "/{id}")
    public Result getInfo(@PathVariable("id") Long id) {
        return Result.success(adminUserService.selectShyUserById(id));
    }

    /**
     * 新增用户
     */
    @PostMapping
    public Result add(@RequestBody ShyUser shyUser) {
        return Result.success(adminUserService.insertShyUser(shyUser));
    }

    /**
     * 修改用户
     */
    @PutMapping
    public Result edit(@RequestBody ShyUser shyUser) {
        return Result.success(adminUserService.updateShyUser(shyUser));
    }

    /**
     * 删除用户
     */
    @DeleteMapping("/{ids}")
    public Result remove(@PathVariable Long[] ids) {
        return Result.success(adminUserService.deleteShyUserByIds(ids));
    }
}
