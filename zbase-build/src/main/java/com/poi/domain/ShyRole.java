package com.poi.domain;

import com.poi.base.BaseForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 角色对象 shy_role
 *
 * @author WangXiang
 * @date 2021-08-12
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ShyRole extends BaseForm {
    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 权限字符
     */
    private String roleValue;

    /**
     * 角色名称
     */
    private String roleName;

    /**
     * 辅助字段 角色对应的权限id
     */
    private Integer[] compIds;

}
