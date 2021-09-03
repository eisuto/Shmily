package com.poi.domain;

import com.poi.base.BaseForm;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

/**
 * 字典对象 shy_dict
 *
 * @author WangXiang
 * @date 2021-08-13
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ShyDict extends BaseForm {
    private static final long serialVersionUID = 1L;


    private Integer id;

    /**
     * 字典类型名称 性别
     */

    private String typeName;

    /**
     * 字典类型值    sys_sex
     */

    private String typeValue;

    /**
     * 字典名称 男
     */

    private String text;

    /**
     * 字典值  男
     */

    private String value;

    /**
     * 状态 1正常 0停用
     */

    private Integer status;


    private Integer delFlag;

    public ShyDict() {
    }

    public ShyDict(String typeName, String typeValue, String text, String value) {
        this.typeName = typeName;
        this.typeValue = typeValue;
        this.text = text;
        this.value = value;
        this.setCreateTime(new Date());
    }
}
