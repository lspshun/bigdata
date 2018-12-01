package day01.java;

import java.util.Scanner;

public class Test03 {

    public static void main(String[] args) {
        // TODO 使用Java方式实现分数的分级
        Scanner scanner = new Scanner(System.in);
        int score = scanner.nextInt();
        String level = "";
        switch (score / 10){
            case 6:
                System.out.println("C");
                level = "C";
                break;
            case 7:
                System.out.println("B");
                level = "B";
                break;
            case 8:
                System.out.println("A");
                level = "A";
                break;
            case 9:
            case 10:
                System.out.println("A+");
                level = "A+";
                break;
            default:
                System.out.println("不及格");
                level = "不及格";
        }

    }
}
