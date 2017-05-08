package com.baobaotao.web.dao;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;

import com.baobaotao.web.common.JsonUtil;
import com.baobaotao.web.domain.AuthDomain;
import com.baobaotao.web.domain.UserDomain;

public class TestAuthDao extends TestBaseDao {

	private static String FILE_NAME = "json/liuning39.1";
	@Autowired
	private AuthDao authDao;

	@Test
	public void testInsert() throws IOException {
		File f = new File(this.getClass().getClassLoader().getResource("")
				.getPath()
				+ FILE_NAME);

		List<AuthDomain> as = JsonUtil.parse(f.getPath());

		for (AuthDomain a : as) {
			AuthDomain newa = new AuthDomain();
			newa.setObject_id(a.getObject_id());
			newa.setObject_type(a.getObject_type());
			newa.setObject_name(a.getObject_name());
			newa.setOp("sys");
			authDao.add(newa);
		}

		assertTrue(as.size() > 0);
	}
}
