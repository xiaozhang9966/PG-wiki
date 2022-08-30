package com.jiawa.wiki.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
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

    @RequestMapping("/hello")//http://127.0.0.1:8080/hello 途径
    public String Hello(){
        return "Hello worle!";
    }
}
