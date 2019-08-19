package com.myheart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

/**
 * @author yangxin
 * @date 2019/8/6
 */
@SpringBootApplication
public class MybatisBootApplication {

    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(MybatisBootApplication.class,args);
        System.out.println("start");
    }
}
