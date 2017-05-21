package com.baobaotao.web.dao.test;

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
    private UserDao userDao;

    @Test(timeout = 10000)
    public void testTruncate() {
        System.out.println("测试 truncate...");

        userDao.truncate();

        assertTrue(true);
    }

    @Test(timeout = 10000)
    public void testAddBatch() {
        System.out.println("测试 addBatch...");

        List<UserDomain> users = new ArrayList<UserDomain>();
        users.add(new UserDomain(1, "1", 1));
        users.add(new UserDomain(2, "2", 2));
        users.add(new UserDomain(3, "3", 3));
        users.add(new UserDomain(4, "4", 4));
        users.add(new UserDomain(5, "5", 5));
        userDao.addBatch(users);

        assertTrue(true);
    }

    @Test(timeout = 10000)
    public void testGetUsers() {
        System.out.println("测试 getUsers...");
        List<Map<String, Object>> l = userDao.getUsers();
        int cnt = l.size();
        assertTrue(cnt > 0);
    }

    @Test(timeout = 10000)
    public void testGetUsersDomain() {
        System.out.println("测试 getUsersDomain...");

        List<UserDomain> users = userDao.getUsersDomain();
        for (UserDomain user : users) {
            System.out.println(String.format("user:%s	%s	%s", user.getId(),
                    user.getName(), user.getAge()));
        }
        int cnt = users.size();
        assertTrue(cnt > 0);
    }

    @Test(timeout = 10000)
    public void testGetUserById() {
        System.out.println("测试 getUserById...");

        Map<String, Object> params = new HashMap<String, Object>();
        params.put("id", "1");
        Map<String, Object> l = userDao.getUserById(params);
        String name = (String) l.get("name");
        assertTrue(!name.isEmpty());
    }

    @Test(timeout = 10000)
    public void testGetUserById2() {
        System.out.println("测试 getUserById2...");

        UserDomain u = new UserDomain();
        u.setId(1);
        UserDomain ru = userDao.getUserById2(u);
        String name = ru.getName();
        assertTrue(!name.isEmpty());
    }

    /**
     * 所有测试开始之前运行
     * <p>
     * 必须为静态方法
     */
    @BeforeClass
    public static void setUpBeforeClass() {
        System.out.println("访问test数据库...");
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
        System.out.println("访问test数据库...END");
    }
}
