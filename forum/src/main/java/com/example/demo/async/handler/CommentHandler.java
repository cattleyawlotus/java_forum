package com.example.demo.async.handler;

import com.example.demo.async.EventHandler;
import com.example.demo.async.EventModel;
import com.example.demo.async.EventType;
import com.example.demo.dao.AnswerDao;
import com.example.demo.dao.MessageDao;
import com.example.demo.dao.UserDao;
import com.example.demo.domain.Message;
import com.example.demo.domain.User;
import com.example.demo.util.HostHolder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * 评论的处理器
 *
 */
@Component
public class CommentHandler implements EventHandler {

	@Autowired
	UserDao userDao;
	
	@Autowired
	MessageDao messageDao;
	
	@Autowired
	HostHolder hostHolder;
	
	@Autowired
	AnswerDao answerDao;
	
	@Override
	public void doHandle(EventModel model) {
		Message message=new Message();
		message.setFromId(model.getActorId());
		message.setToId(model.getEntityOwnerId());
		User user=userDao.getUserById((long) model.getActorId());
		message.setContent("用户"+user.getUsername()+"评论你的话题！");
		message.setCreatedDate(model.getCreatedDate());
		message.setIdTopic(model.getEntityId());
		message.setHasRead(0);
		messageDao.addMessage(message);
	}

	@Override
	public List<EventType> getSupportEventTypes() {
		return Arrays.asList(EventType.COMMENT);
	}

}
