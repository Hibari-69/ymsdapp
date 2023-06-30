package com.ymsd;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@MapperScan("com.ymsd.dao")
@SpringBootApplication
public class YmsdappApplication {

    public static void main(String[] args) {
        SpringApplication.run(YmsdappApplication.class, args);
    }

}
