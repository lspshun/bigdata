package Feng_zhuang7_13;

class person {
    private int age;

    public void setAge(int a) {
        age = a;
    }

    public int getAge() {
        return age;
    }
}

public class Feng_zhuang {
    public static void main(String[] args) {
        person per = new person();
        per.setAge(15);
        System.out.println(per.getAge());

    }
}
