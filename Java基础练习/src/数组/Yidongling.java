package 数组;

public class Yidongling {
    public static void moveZeroes(int nums[]) {
        for (int i = nums.length - 1; i >= 0; i--) {
            int temp = 0;
            if (nums[i] == 0) {
                temp = nums[i];
                for (int j = i; j < nums.length - 1; j++)
                    nums[j] = nums[j + 1];
                nums[nums.length - 1] = temp;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            System.out.println(nums[i]);
        }
    }

    public static void main(String[] args) {
        int A[] = {0, 1, 0, 3, 12};
        moveZeroes(A);
    }
}

