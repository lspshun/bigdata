package day13;

public class HashTest {
    public static void main(String[] args) {
        System.out.println(new Integer(2).hashCode());// 直接返回本身
        System.out.println("abc".hashCode());
        System.out.println("android.learn.com".hashCode() % 3);
        System.out.println("ui.learn.com".hashCode() % 3);
    }
}
