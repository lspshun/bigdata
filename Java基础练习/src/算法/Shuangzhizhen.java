package 算法;

/*
* 给定如下有序数组
A    1 3 5 7
B    2 4 6 8
C    变为有序的数组 1 2 3 4 5 6 7 8
要求用双指针完成
=====================================
设置两个不同的指针 ，或者头，或者尾。
根据结果分类，说明指针的下一步应该怎么移动。
一个while循环+3个条件判断语句来控制指针的走向：
* */
public class Shuangzhizhen {

    public static void main(String[] args) {
        int A[] = {1, 3, 5, 7};
        int B[] = {2, 4, 6, 8};
        for (int i = 0; i < A.length; i++) {
            A[i] = i;
        }
        for (int j = 0; j < B.length; j++) {
            B[j] = j;
        }
        printarray(A);
        printarray(B);
        int C[] = new int [8];

    }

    private static void printarray(int[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

}

