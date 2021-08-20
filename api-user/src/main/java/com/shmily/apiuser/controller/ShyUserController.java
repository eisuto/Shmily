package com.shmily.apiuser.controller;

import java.util.List;

import com.poi.base.Result;
import com.poi.base.TempCache;
import com.poi.domain.ShyUser;
import com.poi.uitls.EmailUtils;
import com.poi.uitls.StringUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
;
import com.shmily.apiuser.service.ShyUserService;

/**
 * 用户Controller
 * 
 * @author eisuto
 * @date 2021-07-14
 */
@Api(tags = "用户端用户服务")
@RestController
@RequestMapping("/api/user")
public class ShyUserController
{
    @Autowired
    private ShyUserService shyUserService;

    /**
     * 登录
     */
    @ApiOperation(value = "登录", notes = "手机号、邮箱、用户名均可")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "nikeName", value = "手机号、邮箱、用户名", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true),
    })
    @PostMapping("/login")
    public Result login(ShyUser user) throws Exception {
        ShyUser shyUser = shyUserService.login(user);
        if(shyUser == null){
            return Result.error("用户名密码错误");
        }
        shyUser.setPassword(null);
        return Result.success(shyUser);
    }

    /**
     * 注册
     */
    @ApiOperation(value = "注册", notes = "用户注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "邮箱", required = true),
            @ApiImplicitParam(name = "verifyCode", value = "验证码（默认传1234）", required = true),
            @ApiImplicitParam(name = "password", value = "密码", required = true),
    })
    @PostMapping("/register")
    public Result register(ShyUser user) throws Exception {
        ShyUser shyUser = shyUserService.register(user);
        return Result.success(shyUser);
    }

    /**
     * 获取验证码
     */
    @ApiOperation(value = "获取验证码", notes = "此验证码用于注册")
    @ApiImplicitParams({
            @ApiImplicitParam(name = "email", value = "接受验证码的邮箱", required = true),
    })
    @PostMapping("/getVerifyCode")
    public Result getVerifyCode(ShyUser user) throws Exception{
        String email = user.getEmail();
        String code = RandomStringUtils.random(6,false,true);
        EmailUtils.sendEmail(email, code);
        TempCache.codeCacheMap.put(email,code);
        return Result.success();
    }
}
