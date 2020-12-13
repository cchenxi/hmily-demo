package io.github.cchenxi.hmily.demo.order;

import org.apache.dubbo.config.annotation.DubboReference;

import io.github.cchenxi.hmily.demo.common.stock.api.StockService;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * Date: 2020-12-13
 *
 * @author chenxi
 */
@SpringBootApplication
@MapperScan("io.github.cchenxi.hmily.demo.common.order.mapper")
public class OrderApplication implements CommandLineRunner {

    @DubboReference
    private StockService stockService;

    public static void main(String[] args) {
        SpringApplication.run(OrderApplication.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        int res = stockService.m1();
        System.out.println("res:" + res);
    }
}
