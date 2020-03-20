package com.baoli.spring.common.enums;

public enum LogTypeEnum {
    SYSTEM("系统日志"),
    BUSINESS("业务日志");
    /**
     * 日志类型
     */
    private String logType;

    LogTypeEnum(String logType) {
        this.logType = logType;
    }

    public String getLogType() {
        return logType;
    }
}
