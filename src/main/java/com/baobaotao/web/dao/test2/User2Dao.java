package com.baobaotao.web.dao.test2;

import com.baobaotao.web.domain.UserDomain;

import java.util.List;
import java.util.Map;

/**
 * @author yangdongyue@jd.com liuning39@jd.com
 * @desc test2数据库中的t_user表
 * <p>
 * com.baobaotao.web.dao.test2.User2Dao 不能与
 * com.baobaotao.web.dao.test.UserDao 类名相同
 * @project baobaotao-web
 * @filename com.baobaotao.web.dao.test2
 * @type User2Dao
 * @since 2017年5月19日
 */
public interface User2Dao {
    List<Map<String, Object>> getUsers();

    List<UserDomain> getUsersDomain();

    Map<String, Object> getUserById(Map<String, Object> params);

    UserDomain getUserById2(UserDomain user);

    void add(UserDomain user);

    void addBatch(List<UserDomain> users);

    void delById(String id);

    void truncate();
}
