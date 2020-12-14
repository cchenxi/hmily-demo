package io.github.cchenxi.hmily.demo.common.account.api;

import io.github.cchenxi.hmily.demo.common.account.dto.AccountDTO;
import org.dromara.hmily.annotation.Hmily;

public interface AccountService {
    @Hmily
    boolean payment(AccountDTO account);
}
