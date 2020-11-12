package com.lisy;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @ControllerAdvice


/**
 *
 * mybatis 启动方式
 *  1、可以在mapper层注入@Mapper Application启动类型不需要加上 @MapperScan 扫描
 *  2、启动类@MapperScan 扫描mapper  mapper层不需要 @Mapper 注释
 */
@MapperScan(basePackages = "com.lisy.mapper")
/**
 * 开启异步调用
 * @EnableAsync
 */



/**
 *
 * 使用指定扫包的方式，节省启动时间，替代 @SpringBootApplication
 * @ComponentScan(basePackages = {"com.lisy.controllers","com.lisy.service"})
 * @EnableAutoConfiguration
 *
 */
@SpringBootApplication
public class SpringbootDemo01Application {
    public static void main(String[] args) {
        SpringApplication.run(SpringbootDemo01Application.class, args);
    }

}