package day06.java;

import java.util.ArrayList;
import java.util.List;

public class StringTest {

    public static void main(String[] args) {
        // TODO 递归实现字符串查找某个字符出现的所有位置
        String s = "123w647w9492w039w";
        find(s,"w",0);
        for (int i:list) {
            System.out.println(i);
        }
    }

    private static List<Integer> list = new ArrayList<>();

    /**
     * 使用递归方式实现字符串中字符出现的所有位置的记录
     * @param s 待查找字符串
     * @param findStr 待查找字符
     * @param index 起始查找索引
     */
    public static void find(String s,String findStr,int index){
        // 返回从起始位置开始查找，第一次出现该字符的位置
        int temp = s.indexOf(findStr,index);
        if (temp == -1){
            // 返回-1代表查找结束
            return;
        }else {
            list.add(temp);
            find(s,findStr,temp + 1);
        }
    }
}
