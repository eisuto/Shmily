package com.poi.adminuser.service.impl;

import com.poi.adminuser.service.AdminUserService;
import com.poi.domain.ShyRole;
import com.poi.domain.ShyUser;
import com.poi.mapper.ShyRoleMapper;
import com.poi.mapper.ShyUserMapper;
import com.poi.uitls.DateUtils;
import com.poi.uitls.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * admin 用户Service业务层处理
 *
 * @author eisuto
 * @date 2021-07-14
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {
    @Autowired
    private ShyUserMapper shyUserMapper;
    @Autowired
    private ShyRoleMapper shyRoleMapper;

    /**
     * 管理员登录
     *
     * @param shyUser
     * @return
     */
    @Override
    public ShyUser login(ShyUser shyUser) throws Exception {
        ShyUser query = new ShyUser();
        query.setEmail(shyUser.getNikeName());
        String role = shyUserMapper.selectShyUserList(query).get(0).getRole();
        if(StringUtils.equals(role,"member")){
            throw new Exception("普通用户不能登录后台系统");
        }
        return shyUserMapper.login(shyUser);
    }

    /**
     * 查询用户
     *
     * @param id 用户ID
     * @return 用户
     */
    @Override
    public ShyUser selectShyUserById(Long id) {
        return shyUserMapper.selectShyUserById(id);
    }

    /**
     * 查询用户列表
     *
     * @param shyUser 用户
     * @return 用户
     */
    @Override
    public List<ShyUser> selectShyUserList(ShyUser shyUser) {
        return shyUserMapper.selectShyUserList(shyUser);
    }

    /**
     * 新增用户
     *
     * @param shyUser 用户
     * @return 结果
     */
    @Override
    public int insertShyUser(ShyUser shyUser) {
        shyUser.setCreateTime(DateUtils.getNowDate());
        return shyUserMapper.insertShyUser(shyUser);
    }

    /**
     * 修改用户
     *
     * @param shyUser 用户
     * @return 结果
     */
    @Override
    public int updateShyUser(ShyUser shyUser) {
        shyUser.setUpdateTime(DateUtils.getNowDate());
        // 先清除以前的角色信息
        shyUserMapper.clearRole(shyUser);
        // 查询修改的角色id
        ShyRole role = new ShyRole();
        role.setRoleValue(shyUser.getRole());
        role = shyRoleMapper.selectShyRoleList(role).get(0);
        shyUser.setRoleId(role.getId());
        // 修改用户 - 角色映射
        shyUserMapper.setRoleRelation(shyUser);
        // 修改用户表
        return shyUserMapper.updateShyUser(shyUser);
    }

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的用户ID
     * @return 结果
     */
    @Override
    public int deleteShyUserByIds(Long[] ids) {
        return shyUserMapper.deleteShyUserByIds(ids);
    }

    /**
     * 删除用户信息
     *
     * @param id 用户ID
     * @return 结果
     */
    @Override
    public int deleteShyUserById(Long id) {
        return shyUserMapper.deleteShyUserById(id);
    }
}
