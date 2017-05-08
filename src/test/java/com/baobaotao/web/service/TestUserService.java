package com.baobaotao.web.service;

import static org.junit.Assert.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.baobaotao.web.domain.UserDomain;

public class TestUserService extends TestBaseService {
	@Autowired
	private UserService userService;

	@Test
	public void testGetUsers() {
		List<Map<String, Object>> l = userService.getUsers();
		int cnt = l.size();
		assertTrue(cnt > 0);
	}

	@Test
	public void testGetUsersDomain() {
		List<UserDomain> users = userService.getUsersDomain();
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
		Map<String, Object> l = userService.getUserById(params);
		String name = (String) l.get("name");
		assertTrue(!name.isEmpty());
	}

	@Test
	public void testGetUserById2() {
		UserDomain u = new UserDomain();
		u.setId(1);
		UserDomain ru = userService.getUserById2(u);
		String name = ru.getName();
		assertTrue(!name.isEmpty());
	}
}
