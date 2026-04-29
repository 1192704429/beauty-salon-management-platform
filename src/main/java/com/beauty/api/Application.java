package com.beauty.api;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.mybatis.spring.annotation.MapperScan;
/**
* @description: 主启动类
* @author: beautyAuthor
* @create: 2024.11.13 11:28:25
*/
@MapperScan("com.beauty.api.dao")
@SpringBootApplication
@Slf4j
public class Application {

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
        log.info("JAVA服务端项目启动成功");
    }

}
