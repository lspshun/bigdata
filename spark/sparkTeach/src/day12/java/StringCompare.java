package day12.java;

import java.lang.reflect.Method;

public class StringCompare {
    public static void main(String[] args) throws Exception {
        // 先逐个比较字符，出现不同时直接返回比较结果 - 字符ASCII做差
        System.out.println("123".compareTo("121"));
        // 当所有已有的字符均相同时比较长度 - 长度做差
        System.out.println("123".compareTo("1"));
    }
}
