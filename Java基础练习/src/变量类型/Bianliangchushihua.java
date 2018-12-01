package 变量类型;

public class Bianliangchushihua {


    public static class Test {
        public void run(){
            // int age; 未初始化变量
            int age = 0; //age 变量使用时要初始化
            age = age + 1;
            System.out.println("年龄是" + age);

        }
    }

    public static void main(String[] args) {
        Test test = new  Test();
        test.run();


    }
}
