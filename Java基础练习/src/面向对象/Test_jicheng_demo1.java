package 面向对象;

class Animal {
    void eat() {
        System.out.println("animal:eat");
    }

}
//final 关键字声明类可以把类定义为不能继承的，即最终类；或者用于修饰方法，该方法不能被子类重写
class dog extends Animal {
    void eat() {
        System.out.println("dog:eat");
    }
    void eatTest() {
        this.eat();
        super.eat();
    }
}


public class Test_jicheng_demo1 {
    public static void main(String[] args) {
        Animal animal = new Animal();
        dog dog = new dog();
        animal.eat();
        dog.eatTest();

    }
}
