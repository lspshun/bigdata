package 基础语法;

import java.util.Scanner;

public class Test_scaner_next {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        //从键盘接受数据
        // next方式接受
        System.out.println("next方式接受");
        if (s.hasNext()){
            String str1 = s.next();
            System.out.println("输入的数据为"+str1);
        }
        s.close();
    }
}
