package com.baoli.thread.common;

import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.Map;

/**
 * @description: Excel文件解析器
 * @author: li baojian
 * @create: 2019/11/04 15:10
 */
public interface ExcelFileHandler {
    public static final String TABLE_NAME="table_name";
    public static final String COLUMN_NAME="column_name";


    Map<String, List<String>> importExcelFile();

    OutputStream exportExcelFile(List<Map<String, Object>> list, OutputStream out);

}
