package String;

// string具有不可变性
// string 两种实例化方法区别
// string 直接赋值  不采用new的方法因为容易产生多个对象产生空间垃圾
public class StringDemo {
    public static void main(String[] args) {
        String str1 = "hello";
        String str2 = new String("hello");
        String str3 = str2;
        //默认不支持 通过intent方法支持
        String str4 = new String("hello").intern();
        //比较的是物理地址
        System.out.println(str1 == str2);
        System.out.println(str4 == str1);
        System.out.println(str2 == str3);
        // 使用equal 比较值是否相等
        System.out.println(str1.equals(str2));
        System.out.println(str2.equals(str1));
        System.out.println(str2.equals(str3));

    }
}
