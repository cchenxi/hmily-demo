package io.github.cchenxi.hmily.demo.common.account.entity;

import lombok.Data;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

/**
 * Date: 2020-12-13
 *
 * @author chenxi
 */
@Data
public class Account implements Serializable {
    private static final long serialVersionUID = 5219239931773717338L;

    private Integer id;

    private String userId;

    private BigDecimal balance;

    private BigDecimal freezeAmount;

    private Date createTime;

    private Date updateTime;
}
