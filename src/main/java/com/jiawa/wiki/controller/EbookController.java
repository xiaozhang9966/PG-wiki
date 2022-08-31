package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.Ebook;
import com.jiawa.wiki.service.EbookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//注解Contorller返回一个页面
@RestController //返回字符串数据   包含@ResponseBody 返回JSON数据
@RequestMapping("/ebook")
public class EbookController {

    @Resource//注入service
    private EbookService ebookService;


    @GetMapping("/list")//支持所有类型 返回List集合 类型为->Ebook自己写的domain 实体类->数据库里的字段 return 调用注入你写的名字ebookService的list方法
    public List<Ebook> list(){
        return ebookService.list();
    }
}
