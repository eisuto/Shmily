package com.poi.domain;

import com.poi.base.BaseForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.List;

/**
 * 权限对象 shy_ompetence
 *
 * @author WangXiang
 * @date 2021-08-14
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ShyCompetence extends BaseForm {
    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 子节点 辅助字段
     */
    private List<ShyCompetence> children;


    /**
     * 父级id
     */
    private Integer fatherId;

    /**
     * 权限名称
     */

    private String name;

    /**
     * 图标
     */

    private String icon;

    /**
     * 菜单排序
     */

    private String order;

    /**
     * 状态
     */

    private Integer status;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("name", getName())
                .append("icon", getIcon())
                .append("order", getOrder())
                .append("status", getStatus())
                .append("createTime", getCreateTime())
                .toString();
    }
}
