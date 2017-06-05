package com.baobaotao.web;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.baobaotao.web.AppConfig;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class TestAppConfig {

    @Autowired
    private AppConfig appConf;

    @Test
    public void testAppConf() {
        System.out.println(appConf.getDebug());
        assertTrue(appConf.getDebug());
        assertTrue(appConf.getVar() == 100);
    }
}
