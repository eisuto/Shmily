package com.poi.mapper;


import com.poi.domain.ShyUser;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Component;

import java.util.List;

/**
 * 用户Mapper接口
 *
 * @author eisuto
 * @date 2021-07-14
 */
@Mapper
public interface ShyUserMapper {


    /**
     * 注册两个用户的关系
     *
     * @param userId
     * @param followId
     * @param status   目标为粉丝1，目标为关注的人2，互关3
     * @return
     */
    public int follow(
            @Param("userId") Long userId,
            @Param("operateId") Long followId,
            @Param("status") Integer status
    );

    /**
     * 清除此用户下的角色信息
     *
     * @param user
     * @return
     */
    public int clearRole(ShyUser user);

    /**
     * 为用户设置角色 中间表
     *
     * @param user
     * @return
     */
    public int setRoleRelation(ShyUser user);

    /**
     * 登录
     *
     * @param user
     * @return
     */
    public ShyUser login(ShyUser user);


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
     * 删除用户
     *
     * @param id 用户ID
     * @return 结果
     */
    public int deleteShyUserById(Long id);

    /**
     * 批量删除用户
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShyUserByIds(Long[] ids);
}
