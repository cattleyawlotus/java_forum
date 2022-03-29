package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * 登录接口
 *
 */
@Controller
public class LoginController {

	@RequestMapping(path = "/login", method = RequestMethod.GET)
	public String login() {
		System.out.println("##################### login ########################");
		return "login";
	}
}
