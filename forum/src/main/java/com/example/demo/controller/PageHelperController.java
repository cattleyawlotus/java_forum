package com.example.demo.controller;


import com.example.demo.domain.PageBean;
import com.example.demo.domain.Topic;
import com.example.demo.service.PageService;
import com.example.demo.util.ForumUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@Controller
public class PageHelperController {
	
	@Autowired
	public PageService pageService;
	
//	@RequestMapping(path="/topics/{category}/{currentPage}",method=RequestMethod.GET)
//	@ResponseBody
	public String pageHelper(@PathVariable String category, @PathVariable int currentPage) {
		PageBean<Topic> pageTopic=pageService.findItemByPage(category, currentPage, 5);
		List<Topic> topics=pageTopic.getItems();
		return ForumUtil.getJSONString(1, topics);
	}
}
