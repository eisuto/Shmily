package com.poi.adminuser.service.impl;

import java.util.List;

import com.poi.adminuser.service.AdminDictService;
import com.poi.uitls.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.poi.mapper.ShyDictMapper;
import com.poi.domain.ShyDict;

/**
 * 字典Service业务层处理
 *
 * @author WangXiang
 * @date 2021-08-13
 */
@Service
public class AdminDictServiceImpl implements AdminDictService {
    @Autowired
    private ShyDictMapper shyDictMapper;

    /**
     * 查询字典
     *
     * @param id 字典ID
     * @return 字典
     */
    @Override
    public ShyDict selectShyDictById(Integer id) {
        return shyDictMapper.selectShyDictById(id);
    }

    /**
     * 查询字典列表
     *
     * @param shyDict 字典
     * @return 字典
     */
    @Override
    public List<ShyDict> selectShyDictList(ShyDict shyDict) {
        return shyDictMapper.selectShyDictList(shyDict);
    }

    /**
     * 新增字典
     *
     * @param shyDict 字典
     * @return 结果
     */
    @Override
    public int insertShyDict(ShyDict shyDict) {
        shyDict.setCreateTime(DateUtils.getNowDate());
        return shyDictMapper.insertShyDict(shyDict);
    }

    /**
     * 修改字典
     *
     * @param shyDict 字典
     * @return 结果
     */
    @Override
    public int updateShyDict(ShyDict shyDict) {
        return shyDictMapper.updateShyDict(shyDict);
    }

    /**
     * 批量删除字典
     *
     * @param ids 需要删除的字典ID
     * @return 结果
     */
    @Override
    public int deleteShyDictByIds(Integer[] ids) {
        return shyDictMapper.deleteShyDictByIds(ids);
    }

    /**
     * 删除字典信息
     *
     * @param id 字典ID
     * @return 结果
     */
    @Override
    public int deleteShyDictById(Integer id) {
        return shyDictMapper.deleteShyDictById(id);
    }
}
