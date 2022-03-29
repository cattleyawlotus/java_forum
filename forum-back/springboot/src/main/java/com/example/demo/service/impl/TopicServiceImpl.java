package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Topic;
import com.example.demo.mapper.TopicMapper;
import com.example.demo.service.ITopicService;
import org.springframework.stereotype.Service;

/**
 * @author : hongbo
 * @create 2021-12-16-19:08
 **/

@Service
public class TopicServiceImpl extends ServiceImpl<TopicMapper, Topic> implements ITopicService {
}
