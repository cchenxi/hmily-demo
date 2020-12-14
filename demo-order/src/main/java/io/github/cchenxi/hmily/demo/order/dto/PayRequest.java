package io.github.cchenxi.hmily.demo.order.dto;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Date: 2020-12-13
 *
 * @author chenxi
 */
@Data
public class PayRequest {
    private BigDecimal amount;
}
