package com.baoli.designmode.templateMethod;

/**
 * @description: 支付操作
 * @author: li baojian
 * @create: 2019/12/25 15:05
 */
public class PayMoneyCommand extends BaseCommand {
    @Override
    protected void doBusiness() {
        log.info("支付操作");
    }
}
