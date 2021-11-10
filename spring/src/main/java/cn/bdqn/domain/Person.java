package cn.bdqn.domain;


import java.util.Date;

public class Person {

    private Integer id;

    private String name;    // 姓名

    private Integer age;    // 年龄

    private Date birthday;  // 出生日期

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", birthday=" + birthday +
                '}';
    }


    public Person(Integer id, String name, Integer age) {
        this.id = id;
        this.name = name;
        this.age = age;
    }

    // 专门为weight属性定义的构造方法
    public Person(Integer id, String name, Date birthday) {
        this.id = id;
        this.name = name;
        this.birthday = birthday;
    }
}
