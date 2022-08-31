package com.jiawa.wiki.service;

import com.fasterxml.jackson.databind.util.BeanUtil;
import com.jiawa.wiki.domain.Ebook;
import com.jiawa.wiki.domain.EbookExample;
import com.jiawa.wiki.mapper.EbookMapper;
import com.jiawa.wiki.req.EbookReq;
import com.jiawa.wiki.resp.EbookResp;
import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

@Service

public class EbookService {
    @Resource
    private EbookMapper ebookMapper;

    public List<EbookResp> list(EbookReq req) {
        EbookExample ebookExample = new EbookExample();//domain下的example mybatis给我门自动生成很多方法了new 处理
        EbookExample.Criteria criteria = ebookExample.createCriteria();//当作where语句  把criter创建出来
        criteria.andNameLike("%" + req.getName() + "%");
        List<Ebook> ebookList = ebookMapper.selectByExample(ebookExample);//selectByExample = 基本查询语句 括号里面就是条件 我们写了where语句下的模糊查询 Like

        List<EbookResp> respList = new ArrayList<>();
        for (Ebook ebook : ebookList) {
            EbookResp ebookResp = new EbookResp();//把响应的类型new出来，才能使用
            BeanUtils.copyProperties(ebook, ebookResp);//要拷贝哪个  到拷贝到哪里去
            respList.add(ebookResp);
        }
        return respList;
    }
}
