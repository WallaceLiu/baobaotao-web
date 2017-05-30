package com.baobaotao.web.di;

/**
 * Created by cap on 2017/5/30.
 */
public class Foo {

    private Bar bar;
    private Baz baz;

    public Foo(Bar bar, Baz baz) {
        this.bar = bar;
        this.baz = baz;
    }

    public void print() {
        bar.print();
        baz.print();
        System.out.println("foo...");
    }
}
