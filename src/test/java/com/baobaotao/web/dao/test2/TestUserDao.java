package com.baobaotao.web.dao.test2;

import com.baobaotao.web.dao.base.TestBaseDao;
import com.baobaotao.web.domain.UserDomain;
import org.junit.*;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.junit.Assert.assertTrue;

public class TestUserDao extends TestBaseDao {
    @Autowired
    private User2Dao userDao;


    @Test
    public void test() {

        userDao.truncate();

        List<UserDomain> users = new ArrayList<UserDomain>();
        users.add(new UserDomain(1, "1", 1));
        users.add(new UserDomain(2, "2", 2));
        users.add(new UserDomain(3, "3", 3));
        users.add(new UserDomain(4, "4", 4));
        users.add(new UserDomain(5, "5", 5));
        userDao.addBatch(users);

        assertTrue(users.size() >= 0);

        List<Map<String, Object>> l = userDao.getUsers();
        int cnt = l.size();
        assertTrue(l.size() >= 0);

        users = userDao.getUsersDomain();
        for (UserDomain user : users) {
            System.out.println(String.format("user:%s	%s	%s", user.getId(),
                    user.getName(), user.getAge()));
        }
        assertTrue(users.size() > 0);

        Map<String, Object> o = new HashMap<String, Object>();
        o.put("id", "1");
        Map<String, Object> l_m = userDao.getUserById(o);
        assertTrue(!l_m.get("name").toString().isEmpty());

        UserDomain u = new UserDomain();
        u.setId(1);
        UserDomain ru = userDao.getUserById2(u);
        assertTrue(!ru.getName().isEmpty());
    }

    /**
     * 所有测试开始之前运行
     * <p>
     * 必须为静态方法
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("访问test2数据库...");
    }

    /**
     * 每一个测试方法之前运行
     *
     * @throws Exception
     */
    @Before
    public void setUp() throws Exception {
        System.out.println("测试中...");
    }

    /**
     * 每一个测试方法之后运行
     */
    @After
    public void tearDown() {
        System.out.println("...");
    }

    /**
     * 所有测试结束之后运行
     * <p>
     * 必须为静态方法
     */
    @AfterClass
    public static void tearDownAfterClass() {
        System.out.println("访问test2数据库...END");
    }
}
