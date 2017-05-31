package com.baobaotao.web.di;

/**
 * Created by cap on 2017/5/30.
 */
public class ExampleBeanSetter {
    // No. of years to the calculate the Ultimate Answer
    private Bar bar;
    private Baz baz;
    private int i;

    public void setBeanOne(Bar beanOne) {
        this.bar = beanOne;
    }

    public void setBeanTwo(Baz beanTwo) {
        this.baz = beanTwo;
    }

    public void setIntegerProperty(int i) {
        this.i = i;
    }

    public void print() {
        bar.print();
        baz.print();
        System.out.println("ExampleBeanSetter...");
    }
}
