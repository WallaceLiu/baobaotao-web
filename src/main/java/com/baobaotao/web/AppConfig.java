package com.baobaotao.web;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class AppConfig {

	@Value("${debug}")
	private Boolean debug;
	@Value("${var}")
	private Integer var;

	public Boolean getDebug() {
		return debug;
	}

	public void setDebug(Boolean debug) {
		this.debug = debug;
	}

	public Integer getVar() {
		return var;
	}

	public void setVar(Integer var) {
		this.var = var;
	}

}
