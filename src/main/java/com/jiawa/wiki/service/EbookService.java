package com.jiawa.wiki.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.jiawa.wiki.aspect.LogAspect;
import com.jiawa.wiki.domain.Ebook;
import com.jiawa.wiki.domain.EbookExample;
import com.jiawa.wiki.mapper.EbookMapper;
import com.jiawa.wiki.req.EbookReq;
import com.jiawa.wiki.resp.EbookResp;
import com.jiawa.wiki.resp.PageResp;
import com.jiawa.wiki.util.CopyUtil;
import com.mysql.cj.log.Log;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service

public class EbookService {
    private final static Logger LOG = LoggerFactory.getLogger(EbookService.class);
    @Resource
    private EbookMapper ebookMapper;

    public PageResp<EbookResp> list(EbookReq req){

        EbookExample ebookExample = new EbookExample();//domain下的example mybatis给我们自动生成了很多方法New 处理 才能调用他的方法
        EbookExample.Criteria criteria = ebookExample.createCriteria();//当作where语句 把criteria创建出来

        if (!ObjectUtils.isEmpty(req.getName())){//不为空 才能执行模糊查询 这样下面的查询selectBy里面是没有where条件的 所有执行的selectByExample查询全部
            criteria.andNameLike("%" + req.getName() + "%");
        }
        PageHelper.startPage(req.getPage(), req.getSize());  //当前页和三条数
        List<Ebook> ebookList  = ebookMapper.selectByExample(ebookExample);//lectByExample = 基本查询语句 括号里面就是你的条件  我们写了where语句 下的模糊查询 Like

        PageInfo<Ebook> pageInfo = new PageInfo<>(ebookList);
        LOG.info("总行数：{}",pageInfo.getTotal());
        LOG.info("总页数：{}",pageInfo.getPages());
        //转换类型 ->list<Ebook> ->List<EbookResp>
//        ArrayList<EbookResp> respList = new ArrayList<>();//ArrayList的使用。* 存储字符串并遍历
//        for (Ebook ebook : ebookList){//foreach循环的意思 ebookList =>ebook
//            EbookResp ebookResp = new EbookResp();//把响应的类型new出来 才能使用
//            BeanUtils.copyProperties(ebook,ebookResp);//1.要拷贝哪个2.要拷贝到哪里去 用于将事件源的数据拷贝到目标源中
//            respList.add(ebookResp);
//      }

        List<EbookResp> list = CopyUtil.copyList(ebookList,EbookResp.class);
        PageResp<EbookResp> pageResp = new PageResp();
        pageResp.setTotal(pageInfo.getTotal());
        pageResp.setList(list);
        return pageResp;
    }
}
