//package com.baobaotao.web.common;
//
//import com.baobaotao.web.domain.Person;
//import com.baobaotao.web.domain.UserDomain;
//import com.google.common.base.Function;
//import com.google.common.base.Functions;
//import com.google.common.collect.Lists;
//import com.google.common.collect.Ordering;
//import org.junit.Test;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//import static org.junit.Assert.assertTrue;
//
//public class TestGuavaFunc {
//
//    @Test
//    public void testFunction() {
//        Map<String, Integer> map = new HashMap<String, Integer>();
//        map.put("love", 1);
//        map.put("miss", 2);
//
//        Function<String, Integer> func = Functions.forMap(map);
//
//        Integer val = func.apply("love");// 调用apply方法，通过key获取value
//
//        System.out.println(val);// i love u
//        // 当apply的key值在Map里不存在时，会抛出异常
//        // java.lang.IllegalArgumentException: Key 'like' not present in map
//        // System.out.println(function.apply("like"));
//        // 我们可以通过forMap重载的另一个方法避免异常，当Key不存在时，设置一个默认值
//        func = Functions.forMap(map, 0);
//        System.out.println(func.apply("like"));// can't find this key
//
//        /**
//         * 有时候，我们需要多个Function进行组合， 这时就需要用到compose，如下：
//         */
//        // 我们有一个Function用于将输入的数字进行平方运算
//        Function<Integer, Integer> f_sqr = new Function<Integer, Integer>() {
//            @Override
//            public Integer apply(Integer input) {
//                return input * input;
//            }
//        };
//        // 我们将上面Map中的value值全部进行平方运算
//        /**
//         * Warning：这里compose方法的参数位置不能颠倒， Function<A, C> compose(Function<B, C>
//         * g, Function<A, ? extends B> f) 传入Function<B,C>、Function<A, ? extends
//         * B>组合成Function<A, C>
//         */
//        Function<String, Integer> result = Functions.compose(f_sqr, func);
//        System.out.println(result.apply("love"));// I LOVE U
//        // 当Key值不存在时，结果也是大写的
//        System.out.println(result.apply("like"));// CAN'T FIND THIS KEY
//    }
//
//    @Test
//    public void test5() {
//        final int i = 100;
//
//        List<UserDomain> us = new ArrayList<UserDomain>();
//        us.add(new UserDomain("1", 1));
//        us.add(new UserDomain("2", 2));
//
//        Function<UserDomain, UserDomain> m = new Function<UserDomain, UserDomain>() {
//            @Override
//            public UserDomain apply(UserDomain u) {
//                u.setAge(u.getAge() * i);
//                u.setName(u.getName() + "u");
//                return u;
//            }
//        };
//        List<UserDomain> l = Lists.transform(us, m);
//
//        for (UserDomain u1 : l) {
//            System.out
//                    .println(String.format("%s %d", u1.getName(), u1.getAge()));
//        }
//
//        assertTrue(true);
//    }
//
//    @Test
//    public void test1() {
//        List<Person> personList = Lists.newArrayList(new Person(3, 1, "abc",
//                        "46546", 0, 25), new Person(2, 1, "ab", "46546", 0, 30),
//                new Person(5, 1, "ade", "46546", 0, 27), new Person(1, 1, "a",
//                        "46546", 1, 20),
//                new Person(6, 1, "acc", "46546", 1, 29), new Person(4, 1,
//                        "aef", "46546", 1, 50), new Person(7, 1, "add",
//                        "46546", 0, 33));
//
//        Ordering<Person> byAge = new Ordering<Person>() {
//            @Override
//            public int compare(Person left, Person right) {
//                return right.getAge() - left.getAge();
//            }
//        };
//
//        for (Person p : byAge.immutableSortedCopy(personList)) {
//            System.out.println(p);
//        }
//    }
//}
