package com.baoli.sso.app1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.oauth2.client.EnableOAuth2Sso;

/**
 * @description: 快速启动类
 * @author: li baojian
 * @create: 2019/12/31 17:04
 */
@EnableOAuth2Sso
@SpringBootApplication
public class AppOneApplication {
    public static void main(String[] args) {
        SpringApplication.run(AppOneApplication.class, args);
    }
}
