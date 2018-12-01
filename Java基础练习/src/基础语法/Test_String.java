package 基础语法;

public class Test_String {
    public static void main(String[] args) {
        char[] hello = {'a', 'b', 'c', 'd', 'e', 'f'};
        //编译器会使用该值创建一个 String 对象。

        //和其它对象一样，可以使用关键字和构造方法来创建 String 对象。
        String helloString = new String(hello);
        System.out.println(helloString);

    }
}
