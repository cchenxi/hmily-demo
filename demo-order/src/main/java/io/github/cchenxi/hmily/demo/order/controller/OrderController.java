package io.github.cchenxi.hmily.demo.order.controller;

import io.github.cchenxi.hmily.demo.order.dto.PayRequest;
import io.github.cchenxi.hmily.demo.order.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Date: 2020-12-13
 *
 * @author chenxi
 */
@RestController
@RequestMapping("order")
public class OrderController {
    private final OrderService orderService;

    @Autowired
    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @PostMapping("pay")
    public String orderPay(@RequestBody PayRequest payRequest) {
        orderService.pay(payRequest);
        return "";
    }
}
