package com.service.impl;

import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.List;

import com.baomidou.mybatisplus.mapper.Wrapper;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.service.impl.ServiceImpl;
import com.utils.PageUtils;
import com.utils.Query;


import com.dao.DiscussyishengzuozhenDao;
import com.entity.DiscussyishengzuozhenEntity;
import com.service.DiscussyishengzuozhenService;
import com.entity.vo.DiscussyishengzuozhenVO;
import com.entity.view.DiscussyishengzuozhenView;

@Service("discussyishengzuozhenService")
public class DiscussyishengzuozhenServiceImpl extends ServiceImpl<DiscussyishengzuozhenDao, DiscussyishengzuozhenEntity> implements DiscussyishengzuozhenService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussyishengzuozhenEntity> page = this.selectPage(
                new Query<DiscussyishengzuozhenEntity>(params).getPage(),
                new EntityWrapper<DiscussyishengzuozhenEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussyishengzuozhenEntity> wrapper) {
		  Page<DiscussyishengzuozhenView> page =new Query<DiscussyishengzuozhenView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussyishengzuozhenVO> selectListVO(Wrapper<DiscussyishengzuozhenEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussyishengzuozhenVO selectVO(Wrapper<DiscussyishengzuozhenEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussyishengzuozhenView> selectListView(Wrapper<DiscussyishengzuozhenEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussyishengzuozhenView selectView(Wrapper<DiscussyishengzuozhenEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
