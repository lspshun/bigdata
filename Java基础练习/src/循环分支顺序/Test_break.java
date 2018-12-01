package 循环分支顺序;

public class Test_break {
    public static void main(String[] args) {

        int [] numbers = {10,20,30,40,50};
        for (int x :numbers){
            // 等于30时跳出循环
            if (x==30){
                break;
            }
            System.out.println(x);

        }

    }
}
