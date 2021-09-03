package com.poi.adminuser.service;

import java.util.List;

import com.poi.domain.ShyCompetence;

/**
 * 权限Service接口
 *
 * @author WangXiang
 * @date 2021-08-14
 */
public interface AdminCompetenceService {



    /**
     * 获取树形结构
     * @return 最外层包含子权限的数组
     */
    public List<ShyCompetence> selectShyCompetenceTree();

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
     * 批量删除权限
     *
     * @param ids 需要删除的权限ID
     * @return 结果
     */
    public int deleteShyCompetenceByIds(Integer[] ids);

    /**
     * 删除权限信息
     *
     * @param id 权限ID
     * @return 结果
     */
    public int deleteShyCompetenceById(Integer id);
}
