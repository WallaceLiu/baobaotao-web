package com.baobaotao.web.dao.test;

import com.baobaotao.web.domain.UserDomain;

import java.util.List;
import java.util.Map;

/**
 * @author yangdongyue@jd.com liuning39@jd.com
 * @desc test数据库中的t_user表
 * <p>
 * com.baobaotao.web.dao.test.UserDao 不能与
 * com.baobaotao.web.dao.test2.User2Dao 类名相同
 * @project baobaotao-web
 * @filename com.baobaotao.web.dao.test
 * @type UserDao
 * @since 2017年5月19日
 */
public interface UserDao {
    List<Map<String, Object>> getUsers();

    List<UserDomain> getUsersDomain();

    Map<String, Object> getUserById(Map<String, Object> params);

    UserDomain getUserById2(UserDomain user);

    void add(UserDomain user);

    void addBatch(List<UserDomain> users);

    void delById(String id);

    void truncate();

}
