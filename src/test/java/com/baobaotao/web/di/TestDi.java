package com.baobaotao.web.di;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.assertTrue;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:spring-config.xml"})
public class TestDi {
    // create and configure beans
    private ApplicationContext context = new ClassPathXmlApplicationContext(new String[]{"classpath:spring-config.xml"});

    @Test
    public void test() {
        Foo foo = (Foo) context.getBean("foo");
        foo.print();

        ExampleBean eb = (ExampleBean) context.getBean("eb");
        ExampleBean eb2 = (ExampleBean) context.getBean("eb2");
        ExampleBean eb3 = (ExampleBean) context.getBean("eb3");

        eb.print();
        eb2.print();
        eb3.print();

        ExampleBeanSetter ebs = (ExampleBeanSetter) context.getBean("exampleBeanSetter");
        ebs.print();

        ComplexObject moreComplexObject = (ComplexObject) context.getBean("moreComplexObject");
        List l = moreComplexObject.getSomeList();
        for (Object o : l) {
            System.out.print(o.toString());
        }

        assertTrue(true);
    }

}
