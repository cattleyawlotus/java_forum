package com.example.demo.controller;


import com.example.demo.dao.AnswerDao;
import com.example.demo.dao.MessageDao;
import com.example.demo.dao.TopicDao;
import com.example.demo.domain.Answer;
import com.example.demo.domain.User;
import com.example.demo.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.view.RedirectView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
public class AnswerController {
	@Autowired
	private AnswerDao answerDao;

	@Autowired
	private TopicDao topicDao;
	
	@Autowired
	private MessageDao messageDao;
	
	@Autowired
	HostHolder hostHolder;

	@RequestMapping(path = "/answers/{id}", method = RequestMethod.GET)
	public String displayAnswersByUser(@PathVariable String id, Model model) {
		List<Answer> answers = answerDao.findAnswerByUser_IdOrderByCreatedDateDesc(Long.parseLong(id));
		
		User user=hostHolder.getUser();
		model.addAttribute("user",user);
		model.addAttribute("newMessage", messageDao.countMessageByToId(user.getId()));
		model.addAttribute("answers", answers);
		model.addAttribute("topicDao", topicDao);
		return "answers";
	}

	@RequestMapping(path = "/answers/useful/{id}", method = RequestMethod.GET)
	public String displayUsefulAnswersByUser(@PathVariable String id, Model model) {
		List<Answer> answers = answerDao.findAnswerByUser_IdAndUsefulOrderByCreatedDateDesc(Long.parseLong(id), true);
		
		User user=hostHolder.getUser();
		model.addAttribute("user",user);
		model.addAttribute("newMessage", messageDao.countMessageByToId(user.getId()));
		model.addAttribute("answers", answers);
		model.addAttribute("topicDao", topicDao);
		return "answers";
	}
	
	/**
	 * 页面跳转bug
	 * @param request
	 * @return
	 */
	@RequestMapping(path = "/answers/message", method = RequestMethod.GET)
	public View answersTransform(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		return new RedirectView(contextPath + "/message");
	}
	
	@RequestMapping(path = "/answers/useful/message", method = RequestMethod.GET)
	public View answerUsefulTransform(HttpServletRequest request) {
		String contextPath = request.getContextPath();
		return new RedirectView(contextPath + "/message");
	}
}
