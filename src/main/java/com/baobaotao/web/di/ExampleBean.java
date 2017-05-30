package com.baobaotao.web.di;

/**
 * Created by cap on 2017/5/30.
 */
public class ExampleBean {
    // No. of years to the calculate the Ultimate Answer
    private int years;

    // The Answer to Life, the Universe, and Everything
    private String ultimateAnswer;

    public ExampleBean(int years, String ultimateAnswer) {
        this.years = years;
        this.ultimateAnswer = ultimateAnswer;
    }

    public void print() {
        System.out.println(String.format("years=%d,ultimateAnswer=%s", years, ultimateAnswer));
    }
}
