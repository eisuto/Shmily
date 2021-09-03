package com.poi.mapper;

import java.util.List;

import com.poi.domain.ShyCompetence;
import com.poi.domain.ShyRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * 权限Mapper接口
 *
 * @author WangXiang
 * @date 2021-08-14
 */
@Mapper
public interface ShyCompetenceMapper {
    /**
     * 查询角色的权限
     */
    public List<ShyCompetence> comps(@Param("roleId") Integer roleId);

    /**
     * 查询权限
     *
     * @param id 权限ID
     * @return 权限
     */
    public ShyCompetence selectShyCompetenceById(Integer id);

    /**
     * 查询权限列表
     *
     * @param shyCompetence 权限
     * @return 权限集合
     */
    public List<ShyCompetence> selectShyCompetenceList(ShyCompetence shyCompetence);

    /**
     * 新增权限
     *
     * @param shyCompetence 权限
     * @return 结果
     */
    public int insertShyCompetence(ShyCompetence shyCompetence);

    /**
     * 修改权限
     *
     * @param shyCompetence 权限
     * @return 结果
     */
    public int updateShyCompetence(ShyCompetence shyCompetence);

    /**
     * 删除权限
     *
     * @param id 权限ID
     * @return 结果
     */
    public int deleteShyCompetenceById(Integer id);

    /**
     * 批量删除权限
     *
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShyCompetenceByIds(Integer[] ids);
}
