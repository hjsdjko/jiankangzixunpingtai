package com.entity.model;

import com.entity.JiaoliuEntity;

import com.baomidou.mybatisplus.annotations.TableName;
import com.fasterxml.jackson.annotation.JsonFormat;
import java.util.Date;
import org.springframework.format.annotation.DateTimeFormat;
import java.io.Serializable;


/**
 * 
 * 接收传参的实体类
 *（实际开发中配合移动端接口开发手动去掉些没用的字段， 后端一般用entity就够用了）
 * 取自ModelAndView 的model名称
 * @email
 * @date 2021-03-11
 */
public class JiaoliuModel implements Serializable {
    private static final long serialVersionUID = 1L;




    /**
     * 主键
     */
    private Long id;


    /**
     * 资讯医生
     */
    private Long ysTypes;


    /**
     * 资讯内容
     */
    private Long yhTypes;


    /**
     * 资讯内容
     */
    private String informationContent;


    /**
     * 资讯时间
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd HH:mm:ss")
	@DateTimeFormat
    private Date informationTime;


    /**
     * 回复内容
     */
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
