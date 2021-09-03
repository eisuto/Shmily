package com.poi.adminuser.service;

import java.util.List;

import com.poi.domain.ShyCompetence;
import com.poi.domain.ShyRole;

/**
 * 角色Service接口
 *
 * @author WangXiang
 * @date 2021-08-12
 */
public interface AdminRoleService {

    /**
     * 查询角色的权限
     * @param shyRole 角色id
     * @return 权限列表
     */
    public List<ShyCompetence> comps(ShyRole shyRole);

    /**
     * 保存角色权限
     * @param form 角色id 权限ids
     * @return 结果
     */
    public int saveComps(ShyRole form);

    /**
     * 查询角色
     *
     * @param id 角色ID
     * @return 角色
     */
    public ShyRole selectShyRoleById(Long id);

    /**
     * 查询角色列表
     *
     * @param shyRole 角色
     * @return 角色集合
     */
    public List<ShyRole> selectShyRoleList(ShyRole shyRole);

    /**
     * 新增角色
     *
     * @param shyRole 角色
     * @return 结果
     */
    public int insertShyRole(ShyRole shyRole);

    /**
     * 修改角色
     *
     * @param shyRole 角色
     * @return 结果
     */
    public int updateShyRole(ShyRole shyRole);

    /**
     * 批量删除角色
     *
     * @param ids 需要删除的角色ID
     * @return 结果
     */
    public int deleteShyRoleByIds(Long[] ids);

    /**
     * 删除角色信息
     *
     * @param id 角色ID
     * @return 结果
     */
    public int deleteShyRoleById(Long id);
}
