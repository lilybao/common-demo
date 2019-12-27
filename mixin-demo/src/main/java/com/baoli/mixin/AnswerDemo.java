package com.baoli.mixin;

import org.junit.Test;
import org.springframework.util.StringUtils;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.HashMap;

/**
 * @description: 答案解析
 * @author: li baojian
 * @create: 2019/12/02 10:05
 */
public class AnswerDemo {

    public HashMap<String, ArrayList> getResource() {
        HashMap<String, ArrayList> map = new HashMap<>();
        try {
            InputStream inputStream = this.getClass().getClassLoader().getResourceAsStream("text.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(inputStream, "UTF-8");
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
            String question = null;
            String s1 = null;
            while ((s1 = bufferedReader.readLine()) != null) {
                ArrayList<String> answers = new ArrayList<>();
                s1 = s1.replace(" ", "");
                if (StringUtils.isEmpty(s1)) {
                    continue;
                }
                if (s1.contains("？") || s1.contains("?")) {
                    question = s1;
                    map.put(s1, answers);
                } else if (!StringUtils.isEmpty(question) && !question.equals("")) {
                    map.get(question).add(s1);
                }
            }
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return map;
    }

    @Test
    public void test() {
        HashMap<String, ArrayList> map = getResource();
        String question = "1/10 项目方能不能冻结我的 Mixin 钱包？\n" +
                "\n" +
                "[A] Mixin 钱包是私人财产，技术上任何人都不能冻结\n" +
                "[B] Mixin 钱包是私人财产，道德要求 Mixin 不能冻结我的钱包\n" +
                "[C] Mixin 钱包是项目方帮我管理的，所以他们可以冻结\n" +
                "[D] Mixin 钱包是私人财产，法律要求 Mixin 不能冻结我的钱包\n" +
                "\n" +
                "请点击下方选项，不要手写答案。";
        String answer = getAnswer(map, question);
        answer = answer.substring(answer.indexOf("[")+1, answer.indexOf("]"));
        System.out.println(answer);
    }

    private String getAnswer(HashMap<String, ArrayList> map, String question) {
        ArrayList list = getQuestionMap(question);
        if (question.contains("?") || question.contains("？")) {
            int l = question.indexOf("？") == 0 ? question.indexOf("?") : question.indexOf("？");
            String str = question.substring(5, l);
            str = str.replace(" ", "");
            for (String key : map.keySet()) {
                if (key.contains(str)) {
                    String s1 = (String) map.get(key).stream().filter(s -> s.toString().contains("√")).findFirst().get();
                    s1 = s1.substring(1, s1.indexOf("√"));
                    final String ss = s1;
                    String s2 = (String) list.stream().filter(s -> s.toString().contains(ss)).findFirst().get();
                    return s2;
                }
            }
        }
        return null;
    }

    private ArrayList getQuestionMap(String question) {
        HashMap<String, ArrayList> map = new HashMap<>();
        ArrayList<String> answers = new ArrayList<>();
        if (question.contains("\n")) {
            String[] split = question.split("\n");
            for (int i = 0; i < split.length; i++) {
                if (StringUtils.isEmpty(split[i].replace(" ", ""))) {
                    continue;
                }
                if (split[i].contains("?") || split[i].contains("？")) {
                    map.put(split[i], answers);
                } else {
                    answers.add(split[i].replace(" ", ""));
                }
            }
        }
        return answers;
    }

    public static void main(String[] args) {
        String a ="1/10 项目方能不能冻结我的 Mixin 钱包？  [A] Mixin 钱包是私人财产，技术上任何人都不能冻结 [B] Mixin 钱包是私人财产，道德要求 Mixin 不能冻结我的钱包 [C] Mixin 钱包是项目方帮我管理的，所以他们可以冻结 [D] Mixin 钱包是私人财产，法律要求 Mixin 不能冻结我的钱包  请点击下方选项，不要手写答案。";
        String question = a.substring(0, a.indexOf("[A]")).trim().replace(" ","");
        String A = a.substring(a.indexOf("[A]"), a.indexOf("[B]")).trim().replace(" ", "");
        String B = a.substring(a.indexOf("[B]"), a.indexOf("[C]")).trim().replace(" ", "");
        String C = a.substring(a.indexOf("[C]"), a.indexOf("[D]")).trim().replace(" ", "");
        String D = a.substring(a.indexOf("[D]"), a.indexOf("请点击")).trim().replace(" ", "");
        ArrayList<String> list = new ArrayList<>();
        list.add(question);
        list.add(A);
        list.add(B);
        list.add(C);
        list.add(D);
        System.out.println(list.toString());
    }
}
