package com.poi.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author WangXiang
 * @date 2022/3/27 20:51
 */
@Mapper
public interface ShyResourcesMapper {

    /**
     * 保存图片地址
     *
     * @return
     */
    public int insertImage(@Param("id") Integer id, @Param("imgUrl") String imgUrl);
}
