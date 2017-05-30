package com.baobaotao.web.di;

import java.beans.ConstructorProperties;

/**
 * Created by cap on 2017/5/30.
 */
public class ExampleBeanAnnotation {
    // No. of years to the calculate the Ultimate Answer
    private int years;

    // The Answer to Life, the Universe, and Everything
    private String ultimateAnswer;

    @ConstructorProperties({"years", "ultimateAnswer"})
    public ExampleBeanAnnotation(int years, String ultimateAnswer) {
        this.years = years;
        this.ultimateAnswer = ultimateAnswer;
    }
}
