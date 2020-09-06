package com.provider.aliyun;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * @author lilili
 * @version 0.0.1
 * @date 2020/8/26 11:18 上午
 */
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.provider.aliyun.dao")
public class Provider003App
{
    public static void main(String[] args) {
        SpringApplication.run(Provider003App.class, args);
    }
}
