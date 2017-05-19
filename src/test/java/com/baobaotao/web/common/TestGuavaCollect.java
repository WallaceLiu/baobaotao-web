package com.baobaotao.web.common;

import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.junit.Test;

import com.baobaotao.web.domain.Person;
import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.BiMap;
import com.google.common.collect.ClassToInstanceMap;
import com.google.common.collect.HashBasedTable;
import com.google.common.collect.HashBiMap;
import com.google.common.collect.HashMultiset;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.Lists;
import com.google.common.collect.Multimap;
import com.google.common.collect.Multiset;
import com.google.common.collect.MutableClassToInstanceMap;
import com.google.common.collect.Sets;
import com.google.common.collect.Table;

public class TestGuavaCollect {

	/**
	 * Guava 简化集合操作
	 */
	@Test
	public void testSimplyCollection() {
		Set<String> s = Sets.newHashSet("one", "two", "three");

		for (String o : s) {
			System.out.print(String.format("%s \t", o));
		}

		System.out.println();

		List<String> l = Lists.newArrayList("one", "two", "three");

		for (String o : l) {
			System.out.print(String.format("%s \t", o));
		}

		System.out.println();

		Map<String, String> m = ImmutableMap.of("ON", "TRUE", "OFF", "FALSE");

		for (String key : m.keySet()) {

			System.out.println(String.format("key=%s,value=%s\t", key,
					m.get(key)));
		}

		System.out.println();

		List<Person> lp = Lists.newArrayList(new Person(1, 1, "a", "46546", 1,
				20), new Person(2, 1, "a", "46546", 1, 20));

		Set<Person> sp = Sets.newHashSet(new Person(1, 1, "a", "46546", 1, 20),
				new Person(2, 1, "a", "46546", 1, 20));

		Map<String, Person> mp = ImmutableMap.of("hello", new Person(1, 1, "a",
				"46546", 1, 20), "fuck", new Person(2, 1, "a", "46546", 1, 20));
	}

	/**
	 * 一种key可以重复的map
	 */
	@Test
	public void testMultimap() {
		Multimap<String, Person> customersByType = ArrayListMultimap.create();
		customersByType.put("abc", new Person(1, 1, "a", "46546", 1, 20));
		customersByType.put("abc", new Person(1, 1, "a", "46546", 1, 30));
		customersByType.put("abc", new Person(1, 1, "a", "46546", 1, 40));
		customersByType.put("abc", new Person(1, 1, "a", "46546", 1, 50));
		customersByType.put("abcd", new Person(1, 1, "a", "46546", 1, 50));
		customersByType.put("abcde", new Person(1, 1, "a", "46546", 1, 50));

		for (Person person : customersByType.get("abc")) {
			System.out.println(person.getC6());
		}
	}

	/**
	 * 不是集合，可以增加重复的元素，并且可以统计出重复元素的个数
	 */
	@Test
	public void testMultiset() {
		Multiset<Integer> multiSet = HashMultiset.create();
		multiSet.add(10);
		multiSet.add(30);
		multiSet.add(30);
		multiSet.add(40);

		System.out.println(multiSet.count(30)); // 2
		System.out.println(multiSet.size()); // 4
	}

	/**
	 * 相当于有两个key的map
	 */
	@Test
	public void testTable() {
		Table<Integer, Integer, Person> pt = HashBasedTable.create();
		pt.put(1, 20, new Person(1, 1, "a", "46546", 1, 20));
		pt.put(0, 30, new Person(2, 1, "ab", "46546", 0, 30));
		pt.put(0, 25, new Person(3, 1, "abc", "46546", 0, 25));
		pt.put(1, 50, new Person(4, 1, "aef", "46546", 1, 50));
		pt.put(0, 27, new Person(5, 1, "ade", "46546", 0, 27));
		pt.put(1, 29, new Person(6, 1, "acc", "46546", 1, 29));
		pt.put(0, 33, new Person(7, 1, "add", "46546", 0, 33));
		pt.put(1, 66, new Person(8, 1, "afadsf", "46546", 1, 66));

		// 1,得到行集合
		Map<Integer, Person> rowMap = pt.row(0);
		int maxAge = Collections.max(rowMap.keySet());
	}

	/**
	 * 一一映射，可以通过key得到value，也可以通过value得到key；
	 */
	@Test
	public void testBitMap() {
		BiMap<Integer, String> biMap = HashBiMap.create();
		biMap.put(1, "hello");
		biMap.put(2, "helloa");
		biMap.put(3, "world");
		biMap.put(4, "worldb");
		biMap.put(5, "my");
		biMap.put(6, "myc");

		int value = biMap.inverse().get("my");
		System.out.println("my --" + value);
	}

	@Test
	public void testClassToInstanceMap() {
		ClassToInstanceMap<Person> cim = MutableClassToInstanceMap.create();

		Person person = new Person(1, 20, "abc", "46464", 1, 100);

		cim.putInstance(Person.class, person);

		// System.out.println("string:"+classToInstanceMap.getInstance(String.class));
		// System.out.println("integer:" +
		// classToInstanceMap.getInstance(Integer.class));

		Person p = cim.getInstance(Person.class);
	}
}
