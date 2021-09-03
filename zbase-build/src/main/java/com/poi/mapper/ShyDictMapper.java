package com.poi.mapper;

import java.util.List;
import com.poi.domain.ShyDict;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Component;

/**
 * 字典Mapper接口
 * 
 * @author WangXiang
 * @date 2021-08-13
 */
@Mapper
public interface ShyDictMapper 
{
    /**
     * 查询字典
     * 
     * @param id 字典ID
     * @return 字典
     */
    public ShyDict selectShyDictById(Integer id);

    /**
     * 查询字典列表
     * 
     * @param shyDict 字典
     * @return 字典集合
     */
    public List<ShyDict> selectShyDictList(ShyDict shyDict);

    /**
     * 新增字典
     * 
     * @param shyDict 字典
     * @return 结果
     */
    public int insertShyDict(ShyDict shyDict);

    /**
     * 修改字典
     * 
     * @param shyDict 字典
     * @return 结果
     */
    public int updateShyDict(ShyDict shyDict);

    /**
     * 删除字典
     * 
     * @param id 字典ID
     * @return 结果
     */
    public int deleteShyDictById(Integer id);

    /**
     * 批量删除字典
     * 
     * @param ids 需要删除的数据ID
     * @return 结果
     */
    public int deleteShyDictByIds(Integer[] ids);
}
