package com.baoli.spring.common.util;

import lombok.Data;

/**
 * @program: common-demo
 * @description: 结果集
 * @author: li baojian
 * @create: 2020-03-19 12:06
 */
@Data
public class ResultData {
    private String msg;
    private boolean success;
    private Object data;

    public ResultData(String msg, boolean success, Object data) {
        this.msg = msg;
        this.success = success;
        this.data = data;
    }

    public ResultData(Object data) {
        this.msg="操作成功";
        this.success=true;
        this.data = data;
    }
}
