package 数组;
// 定义遍历输出数组
public class Test1   {
    public static void main(String[] args) {
        int num[]=new int[10];
        for (int i = 0;i<num.length;i++){
            num[i]= i;

        }
        printarray(num);

    }

    private static void printarray(int[]array) {
        for (int i = 0;i<array.length;i++){
            System.out.println(array[i]);
        }
    }

}
