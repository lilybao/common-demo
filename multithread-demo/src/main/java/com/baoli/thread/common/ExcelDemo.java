package com.baoli.thread.common;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @program: common-demo
 * @description: excel表格内容替换
 * @author: li baojian
 * @create: 2020-04-10 10:55
 */
public class ExcelDemo {
    public static void main(String[] args) {
        ExcelToolsUtil excelToolsUtil = new ExcelToolsUtil();

        try {

            File file = new File("E:\\333.xls");
            FileOutputStream outputStream = new FileOutputStream(file);
            List<Map<String, Object>> list = excelToolsUtil.removeDuplicates();
//            List<Map<String, Object>> list = excelToolsUtil.getList();
            excelToolsUtil.exportExcelFile(list,outputStream);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
    }
}
