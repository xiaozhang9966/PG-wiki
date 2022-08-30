package com.jiawa.wiki.controller;

import com.jiawa.wiki.domain.Test;
import com.jiawa.wiki.service.TestService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

//注解Contorller返回一个页面
@RestController //返回字符串数据   包含@ResponseBody 返回JSON数据
public class TestController {

    @Value("${this.hello:Test}")
    private  String Hello;  //获取配置的自定义的参数


    @Resource//注入service
    private TestService testService;
    /*
    GET POST DELETE PUT
    注解
    @GetMapping
    @PostMapping以此类推
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
     */

    @GetMapping("/hello")//http://127.0.0.1:8080/hello 途径
    public String Hello(){
        return "Hello world!" + Hello;
    }

    @PostMapping("/hello/post")
    public String HelloPost(String name){
        return "Hello world! post" +name;
    }
    @GetMapping("test/list")//支持所有类型 返回List集合 类型为->Test自己写的domain 实体类->数据库里的字段 return 调用注入你写的名字testService的list方法
    public List<Test> list(){
        return testService.list();
    }
}
