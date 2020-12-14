package io.github.cchenxi.hmily.demo.order.service;

import org.apache.dubbo.config.annotation.DubboReference;

import io.github.cchenxi.hmily.demo.common.account.api.AccountService;
import io.github.cchenxi.hmily.demo.common.account.dto.AccountDTO;
import io.github.cchenxi.hmily.demo.common.order.entity.Order;
import io.github.cchenxi.hmily.demo.common.order.enums.OrderStatusEnum;
import io.github.cchenxi.hmily.demo.common.order.mapper.OrderMapper;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * Date: 2020-12-13
 *
 * @author chenxi
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private OrderMapper orderMapper;

    @DubboReference
    private  AccountService accountService;

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public void makePayment(Order order) {
        // 更新订单状态为支付中
        updateOrderStatus(order, OrderStatusEnum.PAYING);
        // 账户扣减金额
        accountService.payment(buildAccount(order));
    }

    private void updateOrderStatus(Order order, OrderStatusEnum orderStatus) {
        order.setStatus(orderStatus.getCode());
        orderMapper.update(order);
    }

    private AccountDTO buildAccount(Order order) {
        AccountDTO accountDTO = new AccountDTO();
        accountDTO.setAmount(order.getTotalAmount());
        accountDTO.setUserId(order.getUserId());
        return accountDTO;
    }

    public void confirm(Order order) {
        // 更新订单状态为支付成功
        updateOrderStatus(order, OrderStatusEnum.PAY_SUCCESS);
    }

    public void cancel(Order order) {
        // 更新订单状态为支付失败
        updateOrderStatus(order, OrderStatusEnum.PAY_FAIL);
    }
}
