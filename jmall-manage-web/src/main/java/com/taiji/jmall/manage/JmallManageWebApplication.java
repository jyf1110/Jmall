package com.taiji.jmall.manage;

import com.alibaba.dubbo.config.spring.context.annotation.DubboComponentScan;
import com.alibaba.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication(exclude={DataSourceAutoConfiguration.class, HibernateJpaAutoConfiguration.class})
@EnableDubbo() //开启dubbo
@DubboComponentScan() //dubbo组件扫描，里面可以带basePackages,也可以不用
public class JmallManageWebApplication {

    public static void main(String[] args) {
        SpringApplication.run(JmallManageWebApplication.class, args);
    }

}
