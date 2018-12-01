package 基础语法;

public class Test_chengji {
    public static void main(String[] args) {
        printchengji(81);

    }
    public static void printchengji(double a){
        if (a>90){
            System.out.println("good");
        }
        else if (a>80){
            System.out.println("not good");
        }
        else{
            System.out.println("f");
        }
    }
}
