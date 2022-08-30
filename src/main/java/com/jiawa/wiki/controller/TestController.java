package com.jiawa.wiki.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.annotation.MergedAnnotationPredicates;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//注解Contorller返回一个页面
@RestController //返回字符串数据   包含@ResponseBody 返回JSON数据
public class TestController {

    @Value("${this.hello:Test}")
    private  String Hello;  //获取配置的自定义的参数

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
}
