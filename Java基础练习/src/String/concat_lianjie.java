package String;

public class concat_lianjie {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = "world";
        // 获取字符串的长度
        int len = str1.length();
        System.out.println(len);

        // 使用concat()方法连接新的字符串
        // 也可以使用+连接字符串
        System.out.println(str1.concat(str2));
    }
}
