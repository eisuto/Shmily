package com.poi.base;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;


import java.util.Date;

/**
 * 基础请求
 */
@Data
public class BaseForm {
    /**
     * 关键字
     */
    private String keyWord;

    /**
     * 页数
     */
    private Integer pageNum;

    /**
     * 大小
     */
    private Integer pageSize;

    /**
     * 创建时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date createTime;

    /**
     * 修改时间
     */
    @JsonFormat(pattern = "yyyy-MM-dd HH:mm:ss")
    private Date updateTime;

    /**
     * 备注
     */
    private String remark;

    /**
     * 删除标记
     */
    private Integer delFlag;


}
