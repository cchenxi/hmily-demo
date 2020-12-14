package io.github.cchenxi.hmily.demo.order.service;

import io.github.cchenxi.hmily.demo.common.order.entity.Order;
import io.github.cchenxi.hmily.demo.common.order.enums.OrderStatusEnum;
import io.github.cchenxi.hmily.demo.common.order.mapper.OrderMapper;
import io.github.cchenxi.hmily.demo.order.dto.PayRequest;
import org.dromara.hmily.common.utils.IdWorkerUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * Date: 2020-12-13
 *
 * @author chenxi
 */
@Service
public class OrderServiceImpl implements OrderService {
    private final OrderMapper orderMapper;

    private final PaymentService paymentService;

    @Autowired(required = false)
    public OrderServiceImpl(OrderMapper orderMapper, PaymentService paymentService) {
        this.orderMapper = orderMapper;
        this.paymentService = paymentService;
    }

    @Override
    public String pay(PayRequest payRequest) {
        final Order order = saveOrder(payRequest);
        orderMapper.save(order);
        paymentService.makePayment(order);
        return "success";
    }

    /**
     * 创建订单
     *
     * @param payRequest
     * @return
     */
    private Order saveOrder(PayRequest payRequest) {
        Order order = new Order();
        order.setCreateTime(new Date());
        order.setNumber(String.valueOf(IdWorkerUtils.getInstance().createUUID()));
        order.setProductId("1");
        order.setStatus(OrderStatusEnum.NOT_PAY.getCode());
        order.setTotalAmount(payRequest.getAmount());
        order.setCount(1);
        order.setUserId("10000");
        return order;
    }
}
