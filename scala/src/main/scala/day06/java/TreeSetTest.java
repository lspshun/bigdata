package day06.java;

import java.util.Set;
import java.util.TreeSet;

class Student implements Comparable<Student>{

    public Student(String name, Integer age) {
        this.name = name;
        this.age = age;
    }

    private String name;
    private Integer age;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Override
    public int compareTo(Student o) {
        // 根据正负判断存放的顺序
        // 得出正数向后放，得出负数向前放
        return this.age - o.age;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}

public class TreeSetTest {

    public static void main(String[] args) {
        // TODO Java比较器复习
        Set<Student> set = new TreeSet<>();
        Student s1 = new Student("s1",19);
        Student s2 = new Student("s2",17);
        Student s3 = new Student("s3",20);
        Student s4 = new Student("s4",18);
        Student s5 = new Student("s4",17);
        Student s6 = new Student("s4",23);
        set.add(s1);
        set.add(s2);
        set.add(s3);
        set.add(s4);
        set.add(s5);
        set.add(s6);
        for (Student s:set) {
            System.out.println(s);
        }
    }
}
