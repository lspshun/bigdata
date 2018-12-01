package Feng_zhuang7_13;

class people {
    private int age;
    private char sex;
    private String name;

    public void setAge(int a) {
        age = a;
    }

    public void setName(String n) {
        name = n;
    }

    public int getAge() {
        return age;
    }

    public String getName() {
        return name;
    }


}

class dog {
    private int high;
    private char name;

    public void setHigh(int h) {
        high = h;

    }

    public int getHigh() {
        return high;
    }
}

public class getset

{

    public static void main(String[] args) {
        dog d = new dog();
        people p = new people();
        d.setHigh(5);
        System.out.println(d.getHigh());


    }
}
