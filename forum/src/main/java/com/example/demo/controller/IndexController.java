package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 首页接口
 *
 */
@Controller
public class IndexController {
	@RequestMapping(path = "/")
	public String index() {
		System.out.println("index");
		return "index";
	}
}
