package com.baoli.designmode.templateMethod;

/**
 * @description: ֧������
 * @author: li baojian
 * @create: 2019/12/25 15:05
 */
public class PayMoneyCommand extends BaseCommand {
    @Override
    protected void doBusiness() {
        log.info("֧������");
    }
}
