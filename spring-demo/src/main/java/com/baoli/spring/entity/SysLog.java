package com.baoli.spring.entity;

import com.baoli.spring.common.base.model.BaseModel;
import com.baoli.spring.common.enums.LogTypeEnum;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

import java.util.Date;

/**
 * @program: common-demo
 * @description: 系统日志
 * @author: li baojian
 * @create: 2020-03-17 14:44
 */
@Data
@TableName("syslog")
public class SysLog  extends BaseModel<SysLog> {
    private String logTitle;
    private LogTypeEnum logType;
    private String requestParams;
    private String LoginName;
    private Date startTime;
    private Date endTime;
    private Long time;
    private String exception;
}
