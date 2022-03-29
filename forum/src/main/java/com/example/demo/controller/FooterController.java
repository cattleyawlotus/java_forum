package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;


/**
 * footer部分的接口
 *

 */
@Controller
public class FooterController {

	@RequestMapping(path = "/aboutUs", method = RequestMethod.GET)
	public String aboutUs() {
		System.out.println("来了吗");
		return "aboutUs";
	}
}
