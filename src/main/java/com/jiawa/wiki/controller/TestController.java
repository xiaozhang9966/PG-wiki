package com.jiawa.wiki.controller;

import org.springframework.core.annotation.MergedAnnotationPredicates;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

//注解Contorller返回一个
@RestController
public class TestController {

    /*
    GET POST DELETE PUT
    注解
    @GetMapping
    @PostMapping以此类推
    @RequestMapping(value = "/hello",method = RequestMethod.GET)
     */

    @GetMapping("/hello")//http://127.0.0.1:8080/hello 途径
    public String Hello(){
        return "Hello world!";
    }

    @PostMapping("/hello/post")
    public String HelloPost(String name){
        return "Hello world! post" +name;
    }
}
