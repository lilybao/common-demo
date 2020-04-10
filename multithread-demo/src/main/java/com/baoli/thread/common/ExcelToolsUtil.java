package com.baoli.thread.common;

import com.sargeraswang.util.ExcelUtil.ExcelLogs;
import com.sargeraswang.util.ExcelUtil.ExcelUtil;
import org.apache.commons.collections.CollectionUtils;
import org.apache.commons.lang3.StringUtils;

import java.io.*;
import java.util.*;

/**
 * @description: Excel工具类
 * @author: li baojian
 * @create: 2019/11/01 18:00
 */
public class ExcelToolsUtil implements ExcelFileHandler {


    public  List<Map<String,Object>>  getList() throws FileNotFoundException {

        File file1 = new File("E:\\123.xlsx");
        InputStream inputStream = new FileInputStream(file1);

        ExcelLogs logs = new ExcelLogs();
        Collection<Map> importExcel = ExcelUtil.importExcel(Map.class, inputStream, "yyyy/MM/dd HH:mm:ss", logs, 0);
        ArrayList<Map<String, Object>> maps = new ArrayList<>();
        HashMap<String, List<String>> map = new HashMap<>();
        for (Map m : importExcel) {
            String c = m.get("指标性质").toString();
            String e = m.get("二级指标分类").toString();
            String i = m.get("方法步骤").toString();
            String f = m.get("目标性指标（单项指标）").toString();
            String l = m.get("指标算式").toString();
            StringBuffer target = new StringBuffer();
            if(StringUtils.isEmpty(f)){
                m.put("指标算式", m.get("指标算式").toString().replace("+","/").replace("O","0"));
                maps.add(m);
                continue;
            }
            if (StringUtils.isNotEmpty(i)) {
                m.put("指标算式", m.get("指标算式").toString().replace("+","/").replace("O","0"));
                maps.add(m);
                continue;
            }
            if(StringUtils.isNotEmpty(c)&&c.contains("定性指标")){
                m.put("指标算式", m.get("指标算式").toString().replace("+","/").replace("O","0"));
                maps.add(m);
                continue;
            }
            String aa="";
            if (c.equals("定量指标")) {
                if(e.contains("国有资产")){
                    if(StringUtils.isNotEmpty(l)&&l.contains("+")&&l.contains("x")&&l.indexOf("+")<l.indexOf("x")){
                        aa=l.substring(l.indexOf("+"),l.indexOf("x"));
                    }
                    if (f.contains("增长率")) {
                        target.append("通过统计局的年度统计报表来获取").append(aa).append("，通过与往年").append(aa).append("对比获取").append(aa)
                                .append("增长率，根据增长率来了解该地区").append("国有资产状况");
                    }else {
                        String ee="";
                        String dd="";
                        if(l.contains("+")&&l.contains("100")){
                            if(l.contains("=")&&l.indexOf("=")<l.indexOf("+")){
                                ee=l.substring(l.indexOf("="),l.indexOf("+"));
                            }else {
                                ee=l.substring(0,l.indexOf("+"));
                            }
                            dd=l.substring(l.indexOf("+"),l.indexOf("100"));
                        }else if(l.contains("+")&&l.contains("x")&&l.contains("=")&&l.indexOf("=")<l.indexOf("+")&&l.indexOf("+")<l.indexOf("x")){
                            ee=l.substring(l.indexOf("="),l.indexOf("+"));
                            dd=l.substring(l.indexOf("+"),l.indexOf("x"));
                        }

                        target.append("通过统计局的年度统计报表来获取").append(ee)
                                .append("占").append(dd).append("比重，通过比重来了解该地区的")
                                .append(e);
                    }
                }else if(f.contains("增长率")){
                    if(StringUtils.isNotEmpty(l)&&l.contains("+")&&l.contains("x")&&l.indexOf("+")<l.indexOf("x")){
                        aa=l.substring(l.indexOf("+"),l.indexOf("x"));
                    }
                    target.append("通过统计局的年度统计报表来获取").append(aa).append("，通过与往年").append(aa).append("对比获取").append(aa)
                            .append("增长率，根据增长率来了解该地区").append("国有资产状况");
                }else{
                    if(l.contains("+")&&l.contains("x")){
                        String ee="";
                        if(l.contains("=")&&l.indexOf("=")<l.indexOf("+")){
                            ee=l.substring(l.indexOf("="),l.indexOf("+"));
                        }else {
                            ee=l.substring(0,l.indexOf("+"));
                        }
                        target.append("通过统计局的年度统计报表来获取").append(ee)
                                .append("占").append(l.substring(l.indexOf("+"),l.indexOf("x"))).append("比重，通过比重来了解该地区的")
                                .append(e);
                    }else if(l.contains("/")&&l.contains("x")){
                        String ee="";
                        if(l.contains("/")&&l.indexOf("/")<l.indexOf("x")){
                            ee=l.substring(0,l.indexOf("/"));
                        }
                        String dd=l.substring(l.indexOf("/"),l.indexOf("x"));
                        target.append("通过统计局的年度统计报表来获取").append(ee)
                                .append("占").append(dd).append("比重，通过比重来了解该地区的")
                                .append(e);
                    }

                }




            }
            m.put("方法步骤", target.toString().replace("+","").replace("x","").replace("=","").replace("(","").replace(")",""));
//            l.replaceFirst("+","/");
            m.put("指标算式", m.get("指标算式").toString().replace("+","/").replace("O","0"));
            maps.add(m);

        }
        HashMap<String, String> headers =initHeaders();

//        try {
//            File file = new File("E:\\333.xlsx");
//            FileOutputStream outputStream = new FileOutputStream(file);
//            ExcelUtil.exportExcel(headers, importExcel, outputStream);
//            outputStream.close();
//        } catch (Exception e) {
//            e.printStackTrace();
//        }

        return maps;
    }



    private HashMap<String, String> initHeaders() {
        HashMap<String, String> headers = new HashMap<>();
        headers.put("1","指标数量");
        headers.put("2","序号");
        headers.put("3","指标性质");
        headers.put("4","一级指标分类");
        headers.put("5","二级指标分类");
        headers.put("6","目标性指标（单项指标）");
        headers.put("7","指标类别");
        headers.put("8","指标解释");
        headers.put("9","方法步骤");
        headers.put("10","影响因素");
        headers.put("11","数据来源");
        headers.put("12","指标算式");
        return headers;
    }


    @Override
    public Map<String, List<String>> importExcelFile() {
        return null;
    }

    @Override
    public OutputStream exportExcelFile(List<Map<String, Object>> list, OutputStream out) {
//        List<Map<String,Object>> list = new ArrayList<>();
//        Map<String,Object> map =new LinkedHashMap<>();
//        map.put("name", "");
//        map.put("age", "");
//        map.put("birthday","");
//        map.put("sex","");
//        Map<String,Object> map2 =new LinkedHashMap<String, Object>();
//        map2.put("name", "测试是否是中文长度不能自动宽度.测试是否是中文长度不能自动宽度.");
//        map2.put("age", null);
//        map2.put("sex", null);
//        map.put("birthday",null);
//        Map<String,Object> map3 =new LinkedHashMap<String, Object>();
//        map3.put("name", "张三");
//        map3.put("age", 12);
//        map3.put("sex", "男");
//        map3.put("birthday",new Date());
//        list.add(map);
//        list.add(map2);
//        list.add(map3);
        Map<String, String> headers = new LinkedHashMap<>();
//        headers.put("1","指标算式");
//        headers.put("2","序号");
//        headers.put("3","指标性质");
//        headers.put("4","一级指标分类");
//        headers.put("5","二级指标分类");
//        headers.put("6","目标性指标（单项指标）");
//        headers.put("7","指标类别");
//        headers.put("8","指标解释");
//        headers.put("9","方法步骤");
//        headers.put("10","影响因素");
//        headers.put("11","数据来源");
//        headers.put("12","指标数量");
        headers.put("指标数量","指标数量");
        headers.put("序号","序号");
        headers.put("指标性质","指标性质");
        headers.put("一级指标分类","一级指标分类");
        headers.put("二级指标分类","二级指标分类");
        headers.put("目标性指标（单项指标）","目标性指标（单项指标）");
        headers.put("指标类别","指标类别");
        headers.put("指标解释","指标解释");
        headers.put("方法步骤","方法步骤");
        headers.put("影响因素","影响因素");
        headers.put("数据来源","数据来源");
        headers.put("指标算式","指标算式");
        ArrayList<Map<String, Object>> list1 = new ArrayList<>();
        try {
            ExcelUtil.exportExcel(headers, list, out);
            out.flush();
            out.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return out;
    }
}
