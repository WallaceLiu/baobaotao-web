package com.baobaotao.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baobaotao.web.AppConfig;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class TestAppContext {

    /**
     * spring-config 出现在两个地方？为什么要添加 ContextConfiguration 注解？
     */
    @Test
    public void test() {
        // create and configure beans
        ApplicationContext context =
                new ClassPathXmlApplicationContext(new String[]{"classpath:spring-config.xml"});

        // retrieve configured instance
        AppConfig appConf = context.getBean("appConfig", AppConfig.class);

        // use configured instance
        Boolean isDebug = appConf.getDebug();
        Integer var = appConf.getVar();

        System.out.println(String.format("%s %s", isDebug.toString(), var.toString()));

        assertTrue(true);
    }
}
