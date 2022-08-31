package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.Demo;
import com.jiawa.wiki.service.DemoService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//注解Contorller返回一个页面
@RestController //返回字符串数据   包含@ResponseBody 返回JSON数据
@RequestMapping("/demo")
public class DemoController {

    @Resource//注入service
    private DemoService demoService;


    @GetMapping("/list")//支持所有类型 返回List集合 类型为->Demo自己写的domain 实体类->数据库里的字段 return 调用注入你写的名字demoService的list方法
    public List<Demo> list(){
        return demoService.list();
    }
}
