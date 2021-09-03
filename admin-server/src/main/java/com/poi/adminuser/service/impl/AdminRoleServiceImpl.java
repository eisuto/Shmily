package com.poi.adminuser.service.impl;

import java.util.List;

import com.poi.adminuser.service.AdminRoleService;
import com.poi.domain.ShyCompetence;
import com.poi.domain.ShyDict;
import com.poi.mapper.ShyCompetenceMapper;
import com.poi.mapper.ShyDictMapper;
import com.poi.uitls.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.poi.mapper.ShyRoleMapper;
import com.poi.domain.ShyRole;


/**
 * 角色Service业务层处理
 *
 * @author WangXiang
 * @date 2021-08-12
 */
@Service
public class AdminRoleServiceImpl implements AdminRoleService {
    @Autowired
    private ShyRoleMapper shyRoleMapper;
    @Autowired
    private ShyDictMapper shyDictMapper;
    @Autowired
    private ShyCompetenceMapper shyCompetenceMapper;

    /**
     * 查询角色的权限
     *
     * @param shyRole
     */
    @Override
    public List<ShyCompetence> comps(ShyRole shyRole) {
        // 如果只有角色值，需要查一下id
        if(shyRole.getId() == null && shyRole.getRoleValue() !=null){
            shyRole = shyRoleMapper.selectShyRoleList(shyRole).get(0);
        }
        return shyCompetenceMapper.comps(shyRole.getId());

    }

    /**
     * 保存角色权限
     *
     * @param form 角色id 权限ids
     * @return 结果
     */
    @Override
    public int saveComps(ShyRole form) {
        // 先清除此角色的全部权限
        shyRoleMapper.clearComps(form.getId());
        // 再分配新的权限
        for (Integer compId : form.getCompIds()) {
            shyRoleMapper.saveComp(form.getId(),compId);
        }
        return 1;
    }

    /**
     * 查询角色
     *
     * @param id 角色ID
     * @return 角色
     */
    @Override
    public ShyRole selectShyRoleById(Long id) {
        return shyRoleMapper.selectShyRoleById(id);
    }

    /**
     * 查询角色列表
     *
     * @param shyRole 角色
     * @return 角色
     */
    @Override
    public List<ShyRole> selectShyRoleList(ShyRole shyRole) {
        return shyRoleMapper.selectShyRoleList(shyRole);
    }

    /**
     * 新增角色
     *
     * @param shyRole 角色
     * @return 结果
     */
    @Override
    public int insertShyRole(ShyRole shyRole) {
        // 角色先保存到字典中
        ShyDict dict = new ShyDict("角色","sys_role",shyRole.getRoleName(),shyRole.getRoleValue());
        shyDictMapper.insertShyDict(dict);
        shyRole.setCreateTime(DateUtils.getNowDate());
        shyRole.setUpdateTime(DateUtils.getNowDate());
        return shyRoleMapper.insertShyRole(shyRole);
    }

    /**
     * 修改角色
     *
     * @param shyRole 角色
     * @return 结果
     */
    @Override
    public int updateShyRole(ShyRole shyRole) {
        shyRole.setUpdateTime(DateUtils.getNowDate());
        return shyRoleMapper.updateShyRole(shyRole);
    }

    /**
     * 批量删除角色
     *
     * @param ids 需要删除的角色ID
     * @return 结果
     */
    @Override
    public int deleteShyRoleByIds(Long[] ids) {
        return shyRoleMapper.deleteShyRoleByIds(ids);
    }

    /**
     * 删除角色信息
     *
     * @param id 角色ID
     * @return 结果
     */
    @Override
    public int deleteShyRoleById(Long id) {
        return shyRoleMapper.deleteShyRoleById(id);
    }
}
