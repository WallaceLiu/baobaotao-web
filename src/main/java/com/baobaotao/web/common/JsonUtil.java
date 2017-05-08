package com.baobaotao.web.common;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.stereotype.Component;

import com.alibaba.fastjson.JSONArray;
import com.baobaotao.web.domain.AuthDomain;

@Component
public class JsonUtil {

	public static List<AuthDomain> parse(String path) throws IOException {

		BufferedReader reader = null;
		String content = "";

		try {
			FileInputStream fis = new FileInputStream(path);
			InputStreamReader isr = new InputStreamReader(fis, "UTF-8");
			reader = new BufferedReader(isr);
			String tempString = null;
			while ((tempString = reader.readLine()) != null) {
				content += tempString;
			}
			reader.close();
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (reader != null) {
				reader.close();
			}
		}

		List<AuthDomain> l = JSONArray.parseArray(content, AuthDomain.class);

		return l;
	}
}
