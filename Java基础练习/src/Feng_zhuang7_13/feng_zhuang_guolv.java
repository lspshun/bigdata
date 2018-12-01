package Feng_zhuang7_13;

class person1 {
    private int age;

    public void setAge(int a) {
        if (a<0) {
            age = 0;
        } else {
            age = a;

        }
    }

    public int getAge() {
        return age;
    }
}

public class feng_zhuang_guolv {
    public static void main(String[] args) {
        person1 per = new person1();
        per.setAge(-10);
        System.out.println(per.getAge());
    }
}
