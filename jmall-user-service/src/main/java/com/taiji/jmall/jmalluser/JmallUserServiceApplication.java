package com.taiji.jmall.jmalluser;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan(basePackages ="com.taiji.jmall.jmalluser.mapper")
public class JmallUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmallUserServiceApplication.class, args);
    }

}
