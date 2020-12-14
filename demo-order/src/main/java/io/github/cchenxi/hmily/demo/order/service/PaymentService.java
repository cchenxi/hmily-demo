package io.github.cchenxi.hmily.demo.order.service;

import io.github.cchenxi.hmily.demo.common.order.entity.Order;

/**
 * Date: 2020-12-13
 *
 * @author chenxi
 */
public interface PaymentService {
    /**
     * 订单支付
     * @param order
     */
    void makePayment(Order order);
}
