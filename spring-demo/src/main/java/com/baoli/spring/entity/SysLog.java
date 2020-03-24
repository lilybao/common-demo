package com.baoli.spring.entity;

import com.baoli.spring.common.base.model.BaseModel;
import com.baoli.spring.common.enums.LogTypeEnum;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @program: common-demo
 * @description: 系统日志
 * @author: li baojian
 * @create: 2020-03-17 14:44
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Accessors(chain = true)
public class SysLog extends BaseModel<SysLog> {
    private static final long serialVersionUID = 1L;
    private String logTitle;
    private LogTypeEnum logType;
    private String requestParams;
    private String LoginName;
    private Date startTime;
    private Date endTime;
    private Long time;
    private String exception;
}
