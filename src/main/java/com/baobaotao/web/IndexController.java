/*
 * Copyright (c) 2015 www.jd.com All rights reserved.
 * 本软件源代码版权归京东成都云平台所有,未经许可不得任意复制与传播.
 */
package com.baobaotao.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 首页
 * 
 * @author J-ONE
 * @since 2015-11-06
 */
@Controller
public class IndexController {

	@RequestMapping(value = "index", method = { RequestMethod.GET,
			RequestMethod.POST })
	public String index() {
		System.out.println("run here");
		// view.addAttribute("contextPath", request.getContextPath());

		return "vm/index";
	}
}
