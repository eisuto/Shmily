package com.poi.domain;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.poi.base.BaseForm;
import lombok.Data;
import org.apache.commons.lang3.builder.ToStringBuilder;
import org.apache.commons.lang3.builder.ToStringStyle;

import java.util.Date;

/**
 * 用户对象 shy_user
 *
 * @author eisuto
 * @date 2021-07-14
 */
@Data
public class ShyUser extends BaseForm {
    private static final long serialVersionUID = 1L;

    /**
     * 辅助变量 验证码
     */
    private String verifyCode;

    /**
     * 辅助变量 角色id
     */
    private Integer roleId;

    /**
     * 用户id
     */
    private Long id;

    /**
     * 昵称
     */
    private String nikeName;

    /**
     * 密码
     */
    private String password;

    /**
     * 邮箱
     */
    private String email;

    /**
     * 性别
     */
    private String sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 生日
     */
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date birthDay;

    /**
     * 手机号码
     */
    private String mobile;

    /**
     * 角色
     */
    private String role;

    /**
     * 头像地址
     */
    private String avatarUrl;

    /**
     * 国家
     */
    private String country;

    /**
     * 状态
     */
    private Integer status;

    /**
     * 粉丝数
     */
    private Integer fans;

    /**
     * 关注数
     */
    private Integer follow;

    /**
     * 主页背景图
     */
    private String homeBackUrl;

    /**
     * 删除标记
     */
    private Integer delFlag;

    /**
     * 简介
     */
    private String summary;


    @Override
    public String toString() {
        return new ToStringBuilder(this, ToStringStyle.MULTI_LINE_STYLE)
                .append("id", getId())
                .append("nikeName", getNikeName())
                .append("password", getPassword())
                .append("email", getEmail())
                .append("sex", getSex())
                .append("age", getAge())
                .append("birthDay", getBirthDay())
                .append("mobile", getMobile())
                .append("role", getRole())
                .append("avatarUrl", getAvatarUrl())
                .append("country", getCountry())
                .append("status", getStatus())
                .append("fans", getFans())
                .append("follow", getFollow())
                .append("homeBackUrl", getHomeBackUrl())
                .append("createTime", getCreateTime())
                .append("updateTime", getUpdateTime())
                .append("delFlag", getDelFlag())
                .append("summary", getSummary())
                .toString();
    }
}
