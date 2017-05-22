package com.baobaotao.web.service.test2;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.baobaotao.web.dao.test2.User2Dao;
import com.baobaotao.web.domain.UserDomain;

@Service
public class User2Service {
	@Autowired
	private User2Dao userDao;

	public List<Map<String, Object>> getUsers() {
		return userDao.getUsers();
	}

	public List<UserDomain> getUsersDomain() {
		return userDao.getUsersDomain();
	}

	public Map<String, Object> getUserById(Map<String, Object> params) {
		return userDao.getUserById(params);
	}

	public UserDomain getUserById2(UserDomain user) {
		return userDao.getUserById2(user);
	}

	public void add(UserDomain user) {
		userDao.add(user);
	}

	public void delById(String id) {
		userDao.delById(id);
	}

	public void addBatch(List<UserDomain> users) {
		userDao.addBatch(users);
	}
}
