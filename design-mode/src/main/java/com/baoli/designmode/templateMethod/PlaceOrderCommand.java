package com.baoli.designmode.templateMethod;

/**
 * @description: 下订单类
 * @author: li baojian
 * @create: 2019/12/25 15:03
 */
public class PlaceOrderCommand extends BaseCommand {
    @Override
    protected void doBusiness() {
        //下订单的业务操作
        log.info("下订单操作");
    }
}
