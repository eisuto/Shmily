package com.poi.domain;

import com.poi.base.BaseForm;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

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

    /**
     * 评论标记
     */
    private int commented;

    /**
     * 转发标记
     */
    private int traned;

    /**
     * 点赞标记
     */
    private int liked;

    /**
     * 评论
     */
    private String comment;

    /**
     * 用户操作类型
     */
    private String type;


    /**
     * 发推者 头像地址
     */
    private String avatarUrl;

    /**
     * 发推者 昵称
     */
    private String nikeName;

    /**
     * id
     */
    private Integer id;

    /**
     * 上传的图片地址
     */
    private String[] uploadImgUrls;

    /**
     * 包含的图片地址
     */
    private List<String> imgUrls;

    /**
     * 单个的图片地址
     */
    private String url;

    /**
     * 发推/点赞/评论/转发 用户id
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
