package com.poi.adminuser.service;

import com.poi.domain.ShyUser;

import java.util.List;

/**
 * admin 用户Service接口
 * 
 * @author eisuto
 * @date 2021-07-14
 */
public interface AdminUserService
{

    /**
     * 管理员登录
     * @param shyUser
     * @return
     */
    public ShyUser login(ShyUser shyUser) throws Exception;

    /**
     * 查询用户
     * 
     * @param id 用户ID
     * @return 用户
     */
    public ShyUser selectShyUserById(Long id);

    /**
     * 查询用户列表
     * 
     * @param shyUser 用户
     * @return 用户集合
     */
    public List<ShyUser> selectShyUserList(ShyUser shyUser);

    /**
     * 新增用户
     * 
     * @param shyUser 用户
     * @return 结果
     */
    public int insertShyUser(ShyUser shyUser);

    /**
     * 修改用户
     * 
     * @param shyUser 用户
     * @return 结果
     */
    public int updateShyUser(ShyUser shyUser);

    /**
     * 批量删除用户
     * 
     * @param ids 需要删除的用户ID
     * @return 结果
     */
    public int deleteShyUserByIds(Long[] ids);

    /**
     * 删除用户信息
     * 
     * @param id 用户ID
     * @return 结果
     */
    public int deleteShyUserById(Long id);
}
