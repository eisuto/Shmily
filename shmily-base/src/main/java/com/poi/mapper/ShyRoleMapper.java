package com.poi.mapper;

import java.util.List;

import com.poi.domain.ShyCompetence;
import com.poi.domain.ShyRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 角色Mapper接口
 *
 * @author WangXiang
 * @date 2021-08-12
 */
@Mapper
public interface ShyRoleMapper {



    /**
     * 清除指定角色的全部权限
     *
     * @param roleId 角色id
     */
    public int clearComps(@Param("roleId") Integer roleId);

    /**
     * 保存指定角色的权限
     *
     * @param roleId 角色id
     * @param compId 权限id
     * @return 结果
     */
    public int saveComp(
            @Param("roleId") Integer roleId,
            @Param("compId") Integer compId);

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
     * 删除角色
     *
     * @param id 角色ID
     * @return 结果
     */
    public int deleteShyRoleById(Long id);

    /**
     * 批量删除角色
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShyRoleByIds(Long[] ids);
}
