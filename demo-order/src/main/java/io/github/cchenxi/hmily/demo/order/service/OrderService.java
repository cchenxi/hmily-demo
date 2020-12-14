package io.github.cchenxi.hmily.demo.order.service;

import io.github.cchenxi.hmily.demo.order.dto.PayRequest;

/**
 * Date: 2020-12-13
 *
 * @author chenxi
 */
public interface OrderService {
    /**
     * 支付
     *
     * @param payRequest 支付参数
     * @return {@link String}
     */
    String pay(PayRequest payRequest);
}
