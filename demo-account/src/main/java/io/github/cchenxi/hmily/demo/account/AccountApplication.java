package io.github.cchenxi.hmily.demo.account;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.WebApplicationType;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Date: 2020-12-13
 *
 * @author chenxi
 */
@SpringBootApplication
@MapperScan("io.github.cchenxi.hmily.demo.common.account.mapper")
@EnableDubbo(scanBasePackages = "io.github.cchenxi.hmily.demo.account.service")
public class AccountApplication {
    public static void main(String[] args) {
        SpringApplication springApplication = new SpringApplication();
        springApplication.setWebApplicationType(WebApplicationType.NONE);
        SpringApplication.run(AccountApplication.class, args);
    }
}
