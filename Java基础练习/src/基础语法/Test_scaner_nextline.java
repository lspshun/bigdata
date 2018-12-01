package 基础语法;


import java.util.Scanner;

public class Test_scaner_nextline {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        // 从键盘接受数据
        // nextline 方法接受字符串
        System.out.println("neztlin方式接受字符串");
        // 判断是否还有输入
        if (scan.hasNextLine()){
            String str = scan.nextLine();
            System.out.println("输入的数据为"+str);
        }
        scan.close();

    }
}
