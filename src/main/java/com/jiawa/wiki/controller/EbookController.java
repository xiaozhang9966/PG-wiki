package com.jiawa.wiki.controller;

import com.jiawa.wiki.req.EbookQueryReq;
import com.jiawa.wiki.req.EbookSaveReq;
import com.jiawa.wiki.resp.CommonResp;
import com.jiawa.wiki.resp.EbookQueryResp;
import com.jiawa.wiki.resp.PageResp;
import com.jiawa.wiki.service.EbookService;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

//注解Contorller返回一个页面
@RestController //返回字符串数据   包含@ResponseBody 返回JSON数据
@RequestMapping("/ebook")
public class EbookController {

    @Resource//注入service
    private EbookService ebookService;


    @GetMapping("/list")//支持所有类型 返回List集合 类型为->Ebook自己写的domain 实体类->数据库里的字段 return 调用注入你写的名字ebookService的list方法
    public CommonResp list(EbookQueryReq req){
        CommonResp<PageResp<EbookQueryResp>> resp = new CommonResp<>();//new Com 返回的参数类型是List集合的Ebook这个实体类的各种数据类型
        PageResp<EbookQueryResp> list = ebookService.list(req);//调用ebookServerice的List方法 返回给list这个变量 类型是List集合的Ebook
        resp.setContent(list);//get方法的set 把数据库的参数设置进来，类型是自定义的List<Ebook>
        return resp;//返回resp
    }

    @PostMapping("/save")
    public CommonResp save(@RequestBody EbookSaveReq req) {
        CommonResp resp = new CommonResp<>();
        ebookService.svae(req);
        return resp;
    }
}
