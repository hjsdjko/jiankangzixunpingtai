package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import org.springframework.transaction.annotation.Transactional;
import com.utils.PageUtils;
import com.utils.Query;

import com.dao.JiaoliuDao;
import com.entity.JiaoliuEntity;
import com.service.JiaoliuService;
import com.entity.view.JiaoliuView;

/**
 *  服务实现类
 * @since 2021-03-11
 */
@Service("jiaoliuService")
@Transactional
public class JiaoliuServiceImpl extends ServiceImpl<JiaoliuDao, JiaoliuEntity> implements JiaoliuService {

    @Override
    public PageUtils queryPage(Map<String,Object> params) {
        if(params != null && (params.get("limit") == null || params.get("page") == null)){
            params.put("page","1");
            params.put("limit","10");
        }
        Page<JiaoliuView> page =new Query<JiaoliuView>(params).getPage();
        page.setRecords(baseMapper.selectListView(page,params));
        return new PageUtils(page);
    }

}
