充值业务

订单系统 order
- 功能: 订单支付
    - http接口: /order/pay
- 数据库
    订单库 订单表

账户系统 account
- 功能: 资金到账
    - dubbo接口: AccountApi#receive
- 数据库
    账户库 账户表