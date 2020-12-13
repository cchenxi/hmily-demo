package io.github.cchenxi.hmily.demo.stock;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Date: 2020-12-13
 *
 * @author chenxi
 */
@SpringBootApplication
@MapperScan("io.github.cchenxi.hmily.demo.common.stock.mapper")
@EnableDubbo(scanBasePackages = "io.github.cchenxi.hmily.demo.stock.service")
public class StockApplication {
    public static void main(String[] args) {
        SpringApplication.run(StockApplication.class, args);
    }
}
