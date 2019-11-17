package com.baobaotao.web.common;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class TestGuavaColl {

//    private static final List<Person> l = Lists.newArrayList(new Person(1, 1, "a",
//                    "46546", 1, 20), new Person(2, 1, "ab", "46546", 0, 30),
//            new Person(3, 1, "abc", "46546", 0, 25), new Person(4, 1,
//                    "aef", "46546", 1, 50), new Person(5, 1, "ade",
//                    "46546", 0, 27),
//            new Person(6, 1, "acc", "46546", 1, 29), new Person(7, 1,
//                    "add", "46546", 0, 33));
//
//    @Test
//    public void testFilter() {
//
//        ImmutableMultiset<Person> r = ImmutableMultiset.copyOf(Collections2
//                .filter(l, new Predicate<Person>() {
//                    @Override
//                    public boolean apply(Person input) {
//                        return input.getSex() == 0;
//                    }
//                }));
//
//        assertTrue(r.size() >= 1);
//    }

//    @Test
//    public void testTansform() {
//
//        ImmutableMultiset<Person> r = ImmutableMultiset.copyOf(Collections2.transform(l, new Function<Person, Person>() {
//            @Override
//            public Person apply(Person input) {
//                input.setAge(input.getAge() * 100);
//                return input;
//            }
//        }));
//
//        assertTrue(r.size() >= 1);
//    }

    @Test
    public void testJava8(){
        List<String> names = Arrays.asList("Jack", "Jill", "Nate", "Kara", "Kim", "Jullie", "Paul", "Peter");

        System.out.println(
                names.stream()
                        .filter(name -> name.length() == 4)
                        .collect(Collectors.joining(", ")));
    }
}
