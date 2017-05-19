package com.baobaotao.web.dao.test;

import static org.junit.Assert.assertTrue;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.baobaotao.web.dao.base.TestBaseDao;
import com.baobaotao.web.domain.UserDomain;

public class TestUserDao extends TestBaseDao {
	@Autowired
	private UserDao userDao;

	@Test
	public void testGetUsers() {
		List<Map<String, Object>> l = userDao.getUsers();
		int cnt = l.size();
		assertTrue(cnt > 0);
	}

	@Test
	public void testGetUsersDomain() {
		List<UserDomain> users = userDao.getUsersDomain();
		for (UserDomain user : users) {
			System.out.println(String.format("user:%s	%s	%s", user.getId(),
					user.getName(), user.getAge()));
		}
		int cnt = users.size();
		assertTrue(cnt > 0);
	}

	@Test
	public void testGetUserById() {
		Map<String, Object> params = new HashMap<String, Object>();
		params.put("id", "1");
		Map<String, Object> l = userDao.getUserById(params);
		String name = (String) l.get("name");
		assertTrue(!name.isEmpty());
	}

	@Test
	public void testGetUserById2() {
		UserDomain u = new UserDomain();
		u.setId(1);
		UserDomain ru = userDao.getUserById2(u);
		String name = ru.getName();
		assertTrue(!name.isEmpty());
	}

	@Test
	public void testAddBatch() {
		List<UserDomain> users = new ArrayList<UserDomain>();
		users.add(new UserDomain("1", 1));
		users.add(new UserDomain("2", 2));
		users.add(new UserDomain("3", 3));
		users.add(new UserDomain("4", 4));
		users.add(new UserDomain("5", 5));
		userDao.addBatch(users);

		assertTrue(true);
	}
}
