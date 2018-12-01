package 面向对象;

// 方法重写
//重写是子类对父类的允许访问的方法的实现过程进行重新编写, 返回值和形参都不能改变。即外壳不变，核心重写！
//重写的好处在于子类可以根据需要，定义特定于自己的行为。 也就是说子类能够根据需要实现父类的方法。
class Animal1 {
    void move()

    {
        System.out.println("动物可以跑走");
    }
}

class dog1 extends Animal1 {
    void move()

    {
        System.out.println("狗可以跑和走");
    }
}


public class Test_override {
    public static void main(String[] args) {
        Animal1 ani = new Animal1();
        dog1 dogg = new dog1();
        ani.move();
        dogg.move();

    }
}
