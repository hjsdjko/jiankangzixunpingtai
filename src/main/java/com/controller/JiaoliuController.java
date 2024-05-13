package com.controller;

import java.text.SimpleDateFormat;
import java.util.*;
import javax.servlet.http.HttpServletRequest;

import com.entity.YishengEntity;
import com.entity.YishengzuozhenEntity;
import com.service.YishengService;
import com.service.YishengzuozhenService;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.JiaoliuEntity;

import com.service.JiaoliuService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 
 * 后端接口
 * @author
 * @email
 * @date 2021-03-11
*/
@RestController
@Controller
@RequestMapping("/jiaoliu")
public class JiaoliuController {
    private static final Logger logger = LoggerFactory.getLogger(JiaoliuController.class);

    @Autowired
    private JiaoliuService jiaoliuService;

    @Autowired
    private YishengService yishengService;

    @Autowired
    private YishengzuozhenService yishengzuozhenService;

    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",page方法");
        PageUtils page = null;
        if(request.getSession().getAttribute("role").equals("用户")){
            params.put("yhTypes",request.getSession().getAttribute("userId"));
            page = jiaoliuService.queryPage(params);
        }else if(request.getSession().getAttribute("role").equals("医生")){
            params.put("ysTypes",request.getSession().getAttribute("userId"));
            page = jiaoliuService.queryPage(params);
        }else{
            page = jiaoliuService.queryPage(params);
        }

        return R.ok().put("data", page);
    }
    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("Controller:"+this.getClass().getName()+",info方法");
        JiaoliuEntity jiaoliu = jiaoliuService.selectById(id);
        if(jiaoliu!=null){
            return R.ok().put("data", jiaoliu);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody JiaoliuEntity jiaoliu, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",save");
        YishengzuozhenEntity yishengzuozhen = yishengzuozhenService.selectById(jiaoliu.getYsTypes());
        if(yishengzuozhen == null){
            return R.error();
        }
        YishengEntity yishenggonghao = yishengService.selectOne(new EntityWrapper().eq("yishengxingming", yishengzuozhen.getYishengxingming()));
        if(yishenggonghao == null){
            return R.error();
        }
        jiaoliu.setYsTypes(yishenggonghao.getId());
        if(!request.getSession().getAttribute("role").equals("用户")){
            return R.error("只有用户可以咨询哦");
        }
        jiaoliu.setYhTypes((Long)request.getSession().getAttribute("userId"));
        Wrapper<JiaoliuEntity> queryWrapper = new EntityWrapper<JiaoliuEntity>()
            .eq("ys_types", jiaoliu.getYsTypes())
            .eq("yh_types", jiaoliu.getYhTypes())
            .eq("information_content", jiaoliu.getInformationContent())
            .eq("reply_content", jiaoliu.getReplyContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaoliuEntity jiaoliuEntity = jiaoliuService.selectOne(queryWrapper);
            jiaoliu.setInformationTime(new Date());
        if(jiaoliuEntity==null){
            jiaoliuService.insert(jiaoliu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody JiaoliuEntity jiaoliu, HttpServletRequest request){
        logger.debug("Controller:"+this.getClass().getName()+",update");
        //根据字段查询是否有相同数据
        Wrapper<JiaoliuEntity> queryWrapper = new EntityWrapper<JiaoliuEntity>()
            .notIn("id",jiaoliu.getId())
            .eq("ys_types", jiaoliu.getYsTypes())
            .eq("yh_types", jiaoliu.getYhTypes())
            .eq("information_content", jiaoliu.getInformationContent())
            .eq("reply_content", jiaoliu.getReplyContent())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        JiaoliuEntity jiaoliuEntity = jiaoliuService.selectOne(queryWrapper);
                jiaoliu.setInformationTime(new Date());
        if(jiaoliuEntity==null){
            jiaoliuService.updateById(jiaoliu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }


    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Long[] ids){
        logger.debug("Controller:"+this.getClass().getName()+",delete");
        jiaoliuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }
}

