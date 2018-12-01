package day03.java;

public class ClassTest {

    public static void main(String[] args) {
        // TODO Java中匿名内部类的使用
        Parent p = new Parent() {
            @Override
            public int method() {
                return 0;
            }
        };
        test(new Parent() {
            @Override
            public int method() {
                return 0;
            }
        });
        System.out.println(new Parent() {

            int b = 10;

            @Override
            public int method() {
                return 0;
            }
        }.b);
    }

    public static void test(Parent p){

    }
}
