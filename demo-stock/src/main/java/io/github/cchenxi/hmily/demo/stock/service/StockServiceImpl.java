package io.github.cchenxi.hmily.demo.stock.service;

import org.apache.dubbo.config.annotation.DubboService;

import io.github.cchenxi.hmily.demo.common.stock.api.StockService;

@DubboService
public class StockServiceImpl implements StockService {
    @Override
    public int m1() {
        return 1;
    }
}
