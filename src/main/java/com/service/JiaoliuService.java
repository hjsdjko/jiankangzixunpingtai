package com.service;

import com.baomidou.mybatisplus.service.IService;
import com.utils.PageUtils;
import com.entity.JiaoliuEntity;
import java.util.Map;

/**
 *  服务类
 * @since 2021-03-11
 */
public interface JiaoliuService extends IService<JiaoliuEntity> {

     PageUtils queryPage(Map<String, Object> params);

}