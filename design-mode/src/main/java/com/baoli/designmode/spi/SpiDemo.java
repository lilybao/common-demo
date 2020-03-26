package com.baoli.designmode.spi;

import sun.misc.Service;

import java.util.Iterator;
import java.util.ServiceLoader;

/**
 * @program: common-demo
 * @description:
 * @author: li baojian
 * @create: 2020-03-26 11:56
 */
public class SpiDemo {
    public static void main(String[] args) {
        //两种方式实现获取到服务接口的实现类
        Iterator<SpiService> providers = Service.providers(SpiService.class);
        ServiceLoader<SpiService> load = ServiceLoader.load(SpiService.class);
        while (providers.hasNext()){
            providers.next().execute();
        }
        Iterator<SpiService> iterator = load.iterator();
        while (iterator.hasNext()){
            iterator.next().execute();
        }
    }
}
