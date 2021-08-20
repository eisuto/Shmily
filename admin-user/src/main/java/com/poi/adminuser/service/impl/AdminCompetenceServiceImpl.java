package com.poi.adminuser.service.impl;

import java.util.ArrayList;
import java.util.List;

import com.poi.adminuser.service.AdminCompetenceService;
import com.poi.domain.ShyCompetence;
import com.poi.uitls.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.poi.mapper.ShyCompetenceMapper;


/**
 * 权限Service业务层处理
 *
 * @author WangXiang
 * @date 2021-08-14
 */
@Service
public class AdminCompetenceServiceImpl implements AdminCompetenceService {
    @Autowired
    private ShyCompetenceMapper shyCompetenceMapper;


    /**
     * 获取树形结构
     *
     * @return 最外层包含子权限的数组
     */
    @Override
    public List<ShyCompetence> selectShyCompetenceTree() {
        List<ShyCompetence> comps = shyCompetenceMapper.selectShyCompetenceList(new ShyCompetence());
        List<ShyCompetence> tree = new ArrayList<>();
        // 先拿到顶级权限 fatherId == 0
        for (ShyCompetence comp : comps) {
            if (comp.getFatherId() == 0) {
                tree.add(comp);
            }
        }
        // 根据拿到的顶级权限，寻找子级权限
        for (ShyCompetence comp : comps) {
            for (ShyCompetence node : tree) {
                if (comp.getFatherId().equals(node.getId())) {
                    List<ShyCompetence> children = new ArrayList<>();
                    if (node.getChildren() != null) {
                        children = node.getChildren();
                    }
                    children.add(comp);
                    node.setChildren(children);

                }
            }

        }
        return tree;

    }

    /**
     * 查询权限
     *
     * @param id 权限ID
     * @return 权限
     */
    @Override
    public ShyCompetence selectShyCompetenceById(Integer id) {
        return shyCompetenceMapper.selectShyCompetenceById(id);
    }

    /**
     * 查询权限列表
     *
     * @param shyCompetence 权限
     * @return 权限
     */
    @Override
    public List<ShyCompetence> selectShyCompetenceList(ShyCompetence shyCompetence) {
        return shyCompetenceMapper.selectShyCompetenceList(shyCompetence);
    }

    /**
     * 新增权限
     *
     * @param shyCompetence 权限
     * @return 结果
     */
    @Override
    public int insertShyCompetence(ShyCompetence shyCompetence) {
        shyCompetence.setCreateTime(DateUtils.getNowDate());
        return shyCompetenceMapper.insertShyCompetence(shyCompetence);
    }

    /**
     * 修改权限
     *
     * @param shyCompetence 权限
     * @return 结果
     */
    @Override
    public int updateShyCompetence(ShyCompetence shyCompetence) {
        return shyCompetenceMapper.updateShyCompetence(shyCompetence);
    }

    /**
     * 批量删除权限
     *
     * @param ids 需要删除的权限ID
     * @return 结果
     */
    @Override
    public int deleteShyCompetenceByIds(Integer[] ids) {
        return shyCompetenceMapper.deleteShyCompetenceByIds(ids);
    }

    /**
     * 删除权限信息
     *
     * @param id 权限ID
     * @return 结果
     */
    @Override
    public int deleteShyCompetenceById(Integer id) {
        return shyCompetenceMapper.deleteShyCompetenceById(id);
    }
}
