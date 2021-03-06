package com.taiji.jmall.jmalluser;

 import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import tk.mybatis.spring.annotation.MapperScan;


@SpringBootApplication
@MapperScan(basePackages ="com.taiji.jmall.jmalluser.mapper")
public class JmallUserServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmallUserServiceApplication.class, args);
    }

}
