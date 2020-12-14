package io.github.cchenxi.hmily.demo.account.service;

import org.apache.dubbo.config.annotation.DubboService;

import io.github.cchenxi.hmily.demo.common.account.api.AccountService;
import io.github.cchenxi.hmily.demo.common.account.dto.AccountDTO;
import io.github.cchenxi.hmily.demo.common.account.entity.Account;
import io.github.cchenxi.hmily.demo.common.account.mapper.AccountMapper;
import lombok.extern.slf4j.Slf4j;
import org.dromara.hmily.annotation.HmilyTCC;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

@DubboService
@Slf4j
public class AccountServiceImpl implements AccountService {
    @Resource
    private AccountMapper accountMapper;

    @Override
    @HmilyTCC(confirmMethod = "confirm", cancelMethod = "cancel")
    public boolean payment(AccountDTO account) {
        return accountMapper.update(account) > 0;
    }

    @Transactional(rollbackFor = Exception.class)
    public boolean confirm(AccountDTO accountDTO) {
        log.info("============dubbo tcc 执行确认付款接口===============");
        accountMapper.confirm(accountDTO);
        return Boolean.TRUE;
    }

    /**
     * Cancel boolean.
     *
     * @param accountDTO the account dto
     * @return the boolean
     */
    @Transactional(rollbackFor = Exception.class)
    public boolean cancel(AccountDTO accountDTO) {
        log.info("============ dubbo tcc 执行取消付款接口===============");
        final Account account = accountMapper.findByUserId(accountDTO.getUserId());
        accountMapper.cancel(accountDTO);
        return Boolean.TRUE;
    }
}
