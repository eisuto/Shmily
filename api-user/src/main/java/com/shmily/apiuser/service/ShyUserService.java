package com.shmily.apiuser.service;

import com.poi.domain.ShyUser;

import java.util.List;

/**
 * 用户Service接口
 * 
 * @author eisuto
 * @date 2021-07-14
 */
public interface ShyUserService
{

    /**
     * 登录
     * @param user
     * @return
     */
    public ShyUser login(ShyUser user);

    /**
     * 注册
     * @param user
     * @return
     */
    public ShyUser register(ShyUser user) throws Exception;


}
