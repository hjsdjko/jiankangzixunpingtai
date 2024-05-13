package com.entity;

import com.baomidou.mybatisplus.annotations.TableId;
import com.baomidou.mybatisplus.annotations.TableName;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import java.lang.reflect.InvocationTargetException;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import com.fasterxml.jackson.annotation.JsonFormat;
import org.apache.commons.beanutils.BeanUtils;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.enums.FieldFill;
import com.baomidou.mybatisplus.enums.IdType;

/**
 * 
 *
 * @email
 * @date 2021-03-11
 */
@TableName("jiaoliu")
public class JiaoliuEntity<T> implements Serializable {
    private static final long serialVersionUID = 1L;


    public JiaoliuEntity() {

    }

    public JiaoliuEntity(T t) {
    try {
    BeanUtils.copyProperties(this, t);
    } catch (IllegalAccessException | InvocationTargetException e) {
    // TODO Auto-generated catch block
    e.printStackTrace();
    }
    }


    /**
     * 主键
     */
    @TableId(type = IdType.AUTO)
    @TableField(value = "id")

    private Long id;


    /**
     * 资讯医生
     */
    @TableField(value = "ys_types")

    private Long ysTypes;


    /**
     * 资讯内容
     */
    @TableField(value = "yh_types")

    private Long yhTypes;


    /**
     * 资讯内容
     */
    @TableField(value = "information_content")

    private String informationContent;


    /**
     * 资讯时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    @TableField(value = "information_time",fill = FieldFill.UPDATE)

    private Date informationTime;


    /**
     * 回复内容
     */
    @TableField(value = "reply_content")

    private String replyContent;


    /**
	 * 设置：主键
	 */
    public Long getId() {
        return id;
    }


    /**
	 * 获取：主键
	 */

    public void setId(Long id) {
        this.id = id;
    }
    /**
	 * 设置：资讯医生
	 */
    public Long getYsTypes() {
        return ysTypes;
    }


    /**
	 * 获取：资讯医生
	 */

    public void setYsTypes(Long ysTypes) {
        this.ysTypes = ysTypes;
    }
    /**
	 * 设置：资讯内容
	 */
    public Long getYhTypes() {
        return yhTypes;
    }


    /**
	 * 获取：资讯内容
	 */

    public void setYhTypes(Long yhTypes) {
        this.yhTypes = yhTypes;
    }
    /**
	 * 设置：资讯内容
	 */
    public String getInformationContent() {
        return informationContent;
    }


    /**
	 * 获取：资讯内容
	 */

    public void setInformationContent(String informationContent) {
        this.informationContent = informationContent;
    }
    /**
	 * 设置：资讯时间
	 */
    public Date getInformationTime() {
        return informationTime;
    }


    /**
	 * 获取：资讯时间
	 */

    public void setInformationTime(Date informationTime) {
        this.informationTime = informationTime;
    }
    /**
	 * 设置：回复内容
	 */
    public String getReplyContent() {
        return replyContent;
    }


    /**
	 * 获取：回复内容
	 */

    public void setReplyContent(String replyContent) {
        this.replyContent = replyContent;
    }

    @Override
    public String toString() {
    return "Jiaoliu{" +
            "id=" + id +
            ", ysTypes=" + ysTypes +
            ", yhTypes=" + yhTypes +
            ", informationContent=" + informationContent +
            ", informationTime=" + informationTime +
            ", replyContent=" + replyContent +
    "}";
    }
    }
