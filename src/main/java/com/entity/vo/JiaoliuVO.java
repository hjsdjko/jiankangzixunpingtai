package com.entity.vo;

import com.entity.JiaoliuEntity;
import com.baomidou.mybatisplus.annotations.TableField;
import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;

import java.io.Serializable;

/**
 * 
 * 手机端接口返回实体辅助类
 * （主要作用去除一些不必要的字段）
 * @email
 * @date 2021-03-11
 */
@TableName("jiaoliu")
public class JiaoliuVO implements Serializable {
    private static final long serialVersionUID = 1L;


    /**
     * 主键
     */

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

    @TableField(value = "information_time")
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

}
