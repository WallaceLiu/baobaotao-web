package com.baobaotao.web.common;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.baobaotao.web.domain.Person;
import com.baobaotao.web.domain.UserDomain;
import com.google.common.base.Function;
import com.google.common.base.Functions;
import com.google.common.base.Predicate;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.SetMultimap;
import com.google.common.collect.Collections2;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ImmutableMultiset;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Ordering;
import com.google.common.collect.Sets;

public class TestGuavaFunc {

	@Test
	public void testFunction() {
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("love", 1);
		map.put("miss", 2);

		/**
		 * forMap
		 */
		Function<String, Integer> function = Functions.forMap(map);
		// 调用apply方法，可以通过key获取相应的value
		System.out.println(function.apply("love"));// i love u
		// 当apply的key值在Map里不存在时，会抛出异常
		// java.lang.IllegalArgumentException: Key 'like' not present in map
		// System.out.println(function.apply("like"));
		// 我们可以通过forMap重载的另一个方法避免异常，当Key不存在时，设置一个默认值
		function = Functions.forMap(map, 0);
		System.out.println(function.apply("like"));// can't find this key
		/**
		 * 有时候，我们需要多个Function进行组合， 这时就需要用到compose，如下：
		 */
		// 我们有一个Function用于将输入的数字进行平方运算
		Function<Integer, Integer> function1 = new Function<Integer, Integer>() {
			@Override
			public Integer apply(Integer input) {
				return input * input;
			}
		};
		// 我们将上面Map中的value值全部进行平方运算
		/**
		 * Warning：这里compose方法的参数位置不能颠倒， Function<A, C> compose(Function<B, C>
		 * g, Function<A, ? extends B> f) 传入Function<B,C>、Function<A, ? extends
		 * B>组合成Function<A, C>
		 */
		Function<String, Integer> result = Functions.compose(function1,
				function);
		System.out.println(result.apply("love"));// I LOVE U
		// 当Key值不存在时，结果也是大写的
		System.out.println(result.apply("like"));// CAN'T FIND THIS KEY
	}

	@Test
	public void test4() {
		List<Person> personList = Lists.newArrayList(new Person(1, 1, "a",
				"46546", 1, 20), new Person(2, 1, "ab", "46546", 0, 30),
				new Person(3, 1, "abc", "46546", 0, 25), new Person(4, 1,
						"aef", "46546", 1, 50), new Person(5, 1, "ade",
						"46546", 0, 27),
				new Person(6, 1, "acc", "46546", 1, 29), new Person(7, 1,
						"add", "46546", 0, 33));

		ImmutableMultiset<Person> l = ImmutableMultiset.copyOf(Collections2
				.filter(personList, new Predicate<Person>() {
					@Override
					public boolean apply(Person input) {
						return input.getC5() == 0;
					}
				}));

		assertTrue(true);
	}

	@Test
	public void test5() {
		final int i = 100;

		List<UserDomain> us = new ArrayList<UserDomain>();
		us.add(new UserDomain("1", 1));
		us.add(new UserDomain("2", 2));

		Function<UserDomain, UserDomain> m = new Function<UserDomain, UserDomain>() {
			public UserDomain apply(UserDomain u) {
				u.setAge(u.getAge() * i);
				u.setName(u.getName() + "u");
				return u;
			}
		};
		List<UserDomain> l = Lists.transform(us, m);

		for (UserDomain u1 : l) {
			System.out
					.println(String.format("%s %d", u1.getName(), u1.getAge()));
		}

		assertTrue(true);
	}

	@Test
	public void test1() {
		List<Person> personList = Lists.newArrayList(new Person(3, 1, "abc",
				"46546", 0, 25), new Person(2, 1, "ab", "46546", 0, 30),
				new Person(5, 1, "ade", "46546", 0, 27), new Person(1, 1, "a",
						"46546", 1, 20),
				new Person(6, 1, "acc", "46546", 1, 29), new Person(4, 1,
						"aef", "46546", 1, 50), new Person(7, 1, "add",
						"46546", 0, 33));

		Ordering<Person> byAge = new Ordering<Person>() {
			@Override
			public int compare(Person left, Person right) {
				return right.getC6() - left.getC6();
			}
		};

		for (Person p : byAge.immutableSortedCopy(personList)) {
			System.out.println(p);
		}
	}

	public void t() {

	}

}
