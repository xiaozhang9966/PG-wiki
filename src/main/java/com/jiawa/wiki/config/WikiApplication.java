package com.jiawa.wiki.config;


import org.mybatis.spring.annotation.MapperScan;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.core.env.Environment;
import org.slf4j.Logger;

//@ComponentScan("com.xxx",com."xxx")扫描多个包
@ComponentScan("com.jiawa")//扫描以下全部包，交给spring处理
@SpringBootApplication
@MapperScan("com.jiawa.wiki.mapper")//让springboot知道哪里是持久层
public class WikiApplication {

    private static final Logger LOG = LoggerFactory.getLogger(WikiApplication.class);
    public static void main(String[] args) {

        SpringApplication app = new SpringApplication(WikiApplication.class);
        Environment env = app.run(args).getEnvironment();
        LOG.info("启动成功");
        LOG.info("地址:\thttp://127.0.0.1:{}",env.getProperty("server.port"));
    }

}
