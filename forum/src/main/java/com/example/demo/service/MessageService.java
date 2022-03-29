package com.example.demo.service;


import com.example.demo.dao.MessageDao;
import com.example.demo.domain.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class MessageService {
	
	@Autowired
	private MessageDao messageDao;
	
	public List<Message> getReadMessageById(Long id){
		List<Message> messages=messageDao.getMessageByToId(id);
		return messages;
	}
	
	public List<Message> getUnreadMessageById(Long id){
		List<Message> unReadMessages=messageDao.getUnReadMessageByToId(id);
		return unReadMessages;
	}
}
