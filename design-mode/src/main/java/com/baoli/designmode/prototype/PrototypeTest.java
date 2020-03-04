package com.baoli.designmode.prototype;

/**
 * @description: 原型模式测试
 * 通过定义一个抽象类，定义好具体的方法
 * 然后实现一个原型  通过原型的一个方法  可以复制出更多的抽象类的 实现
 * @author: li baojian
 * @create: 2020/01/19 09:58
 */
public class PrototypeTest {
    public static void main(String[] args) {
        DemoPrototype demoPrototype = new CreatePrototype("测试原型");
        DemoPrototype cloneto = demoPrototype.cloneto();
        System.out.println(cloneto.toString());
    }
}
