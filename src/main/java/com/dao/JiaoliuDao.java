package com.dao;

import com.entity.JiaoliuEntity;
import com.baomidou.mybatisplus.mapper.BaseMapper;
import java.util.List;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;

import org.apache.ibatis.annotations.Param;
import com.entity.view.JiaoliuView;

/**
 *  Dao 接口
 *
 * @since 2021-03-11
 */
public interface JiaoliuDao extends BaseMapper<JiaoliuEntity> {

   List<JiaoliuView> selectListView(Pagination page,@Param("params")Map<String,Object> params);

}
