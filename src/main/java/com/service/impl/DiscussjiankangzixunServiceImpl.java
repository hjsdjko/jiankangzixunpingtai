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


import com.dao.DiscussjiankangzixunDao;
import com.entity.DiscussjiankangzixunEntity;
import com.service.DiscussjiankangzixunService;
import com.entity.vo.DiscussjiankangzixunVO;
import com.entity.view.DiscussjiankangzixunView;

@Service("discussjiankangzixunService")
public class DiscussjiankangzixunServiceImpl extends ServiceImpl<DiscussjiankangzixunDao, DiscussjiankangzixunEntity> implements DiscussjiankangzixunService {


    @Override
    public PageUtils queryPage(Map<String, Object> params) {
        Page<DiscussjiankangzixunEntity> page = this.selectPage(
                new Query<DiscussjiankangzixunEntity>(params).getPage(),
                new EntityWrapper<DiscussjiankangzixunEntity>()
        );
        return new PageUtils(page);
    }
    
    @Override
	public PageUtils queryPage(Map<String, Object> params, Wrapper<DiscussjiankangzixunEntity> wrapper) {
		  Page<DiscussjiankangzixunView> page =new Query<DiscussjiankangzixunView>(params).getPage();
	        page.setRecords(baseMapper.selectListView(page,wrapper));
	    	PageUtils pageUtil = new PageUtils(page);
	    	return pageUtil;
 	}
    
    @Override
	public List<DiscussjiankangzixunVO> selectListVO(Wrapper<DiscussjiankangzixunEntity> wrapper) {
 		return baseMapper.selectListVO(wrapper);
	}
	
	@Override
	public DiscussjiankangzixunVO selectVO(Wrapper<DiscussjiankangzixunEntity> wrapper) {
 		return baseMapper.selectVO(wrapper);
	}
	
	@Override
	public List<DiscussjiankangzixunView> selectListView(Wrapper<DiscussjiankangzixunEntity> wrapper) {
		return baseMapper.selectListView(wrapper);
	}

	@Override
	public DiscussjiankangzixunView selectView(Wrapper<DiscussjiankangzixunEntity> wrapper) {
		return baseMapper.selectView(wrapper);
	}

}
