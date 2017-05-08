package com.baobaotao.web.dao;

import java.util.List;
import java.util.Map;

import com.baobaotao.web.domain.UserDomain;

public interface UserDao {
	public List<Map<String, Object>> getUsers();

	public List<UserDomain> getUsersDomain();

	public Map<String, Object> getUserById(Map<String, Object> params);

	public UserDomain getUserById2(UserDomain user);

	public void add(UserDomain user);

	public void addBatch(List<UserDomain> users);

	public void delById(String id);

}
