package com.baobaotao.web.domain;

public class Person {
    private Integer id;
    private Integer dept;
    private String name;
    private String c4;
    private Integer sex;
    private Integer age;

    public Person(Integer id, Integer dept, String name, String c4, Integer sex,
                  Integer age) {
        this.id = id;
        this.dept = dept;
        this.name = name;
        this.c4 = c4;
        this.sex = sex;
        this.age = age;
    }

    public String getC4() {
        return c4;
    }

    public void setC4(String c4) {
        this.c4 = c4;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public Integer getDept() {
        return dept;
    }

    public void setDept(Integer dept) {
        this.dept = dept;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
