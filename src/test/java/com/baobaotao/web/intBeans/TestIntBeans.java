package com.baobaotao.web.intBeans;

import com.baobaotao.web.IntBeans.CliServiceImpl;
import com.baobaotao.web.IntBeans.ClientService;
import com.baobaotao.web.IntBeans.ExampleBean;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class TestIntBeans {
    // create and configure beans
    private ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring-config.xml"});

    @Test
    public void test1() {
        // retrieve configured instance
        ExampleBean exampleBean = context.getBean("exampleBean", ExampleBean.class);

        // use configured instance
        exampleBean.print();

        ClientService clientService = context.getBean("clientService", ClientService.class);
        clientService.print();

        CliServiceImpl cliService = context.getBean("cliService", CliServiceImpl.class);
        cliService.print();

        assertTrue(true);
    }

}
