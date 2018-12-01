package day01.java;

public class Test04 {

    public static void main(String[] args) {
        // TODO 使用Java方式实现生成新的数组
        int[] a = {1,3,5,7,9};
        int[] result = new int[a.length];
        for (int i = 0;i < a.length;i ++){
            result[i] = a[i] * a[i];
        }
        for (int temp : result) {
            System.out.println(temp);
        }
    }
}
