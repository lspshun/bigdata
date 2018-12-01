package 循环分支顺序;

public class Test_continue {
    public static void main(String[] args) {
        int [] numbers = { 1,2,3,4,5,6,};
        for (int x :numbers){
            if (x==3){
                continue;
            }
            System.out.println(x);
        }
    }
}
