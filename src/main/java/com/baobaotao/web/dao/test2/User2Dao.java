package com.baobaotao.web.dao.test2;

import java.util.List;
import java.util.Map;

import com.baobaotao.web.domain.UserDomain;

/**
 * @desc test2数据库中的t_user表
 * 
 *       com.baobaotao.web.dao.test2.User2Dao 不能与
 *       com.baobaotao.web.dao.test.UserDao 类名相同
 * 
 * @author yangdongyue@jd.com liuning39@jd.com
 * @project baobaotao-web
 * @filename com.baobaotao.web.dao.test2
 * @type User2Dao
 * @since 2017年5月19日
 */
public interface User2Dao {
	public List<Map<String, Object>> getUsers();

	public List<UserDomain> getUsersDomain();

	public Map<String, Object> getUserById(Map<String, Object> params);

	public UserDomain getUserById2(UserDomain user);

	public void add(UserDomain user);

	public void addBatch(List<UserDomain> users);

	public void delById(String id);

}
