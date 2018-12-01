package day07.java;

import java.util.Random;

public class RandomTest {

    public static void main(String[] args) {
        // TODO 生成指定区间的随机数 - seed
        int a = (int)(Math.random() * (9 - 6 + 1)+ 3);
        System.out.println(a);
        Random random1 = new Random(2);
        System.out.println(random1.nextInt(10));
        System.out.println(random1.nextInt(10));
        System.out.println(random1.nextInt(10));
        System.out.println(random1.nextInt(10));
        Random random2 = new Random(2);
        System.out.println(random2.nextInt(10));
        System.out.println(random2.nextInt(10));
        System.out.println(random2.nextInt(10));
        System.out.println(random2.nextInt(10));
    }
}
