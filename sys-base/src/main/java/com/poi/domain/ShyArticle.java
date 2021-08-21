package com.poi.domain;

import com.poi.base.BaseForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

/**
 * 推文对象 shy_article
 *
 * @author WangXiang
 * @date 2021-08-13
 */
@EqualsAndHashCode(callSuper = true)
@Data
public class ShyArticle extends BaseForm {
    private static final long serialVersionUID = 1L;

    private Integer id;

    /**
     * 发推用户id
     */
    private Integer userId;

    /**
     * 标签
     */
    private String tab;

    /**
     * 内容
     */
    private String info;

    /**
     * 收藏数
     */
    private Integer collectNum;

    /**
     * 评论数
     */
    private Integer commentNum;

    /**
     * 转发数
     */
    private Integer transpondNum;

    /**
     * 喜欢数
     */
    private Integer loveNum;

    /**
     * 热搜指数
     */
    private Integer hot;

    /**
     * 状态 1正常 0隐藏
     */
    private Integer status;

    /**
     * 删除标记
     */
    private Integer delFlag;

    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("info", getInfo())
                .append("collectNum", getCollectNum())
                .append("commentNum", getCommentNum())
                .append("transpondNum", getTranspondNum())
                .append("loveNum", getLoveNum())
                .append("hot", getHot())
                .append("status", getStatus())
                .append("createTime", getCreateTime())
                .append("delFlag", getDelFlag())
                .toString();
    }
}
