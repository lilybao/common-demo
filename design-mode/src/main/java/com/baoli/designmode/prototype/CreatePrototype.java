package com.baoli.designmode.prototype;

/**
 * @description: 创建原型
 * @author: li baojian
 * @create: 2020/01/19 09:57
 */
public class CreatePrototype extends DemoPrototype {
    private String name;

    public CreatePrototype(String name) {
        this.name = name;
    }

    @Override
    DemoPrototype cloneto() {
        return new CreatePrototype(name);
    }

    @Override
    public String toString() {
        return name;
    }
}
