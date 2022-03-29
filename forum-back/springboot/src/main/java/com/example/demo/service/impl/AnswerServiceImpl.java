package com.example.demo.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.demo.entity.Answer;
import com.example.demo.mapper.AnswerMapper;
import com.example.demo.service.IAnswerService;
import org.springframework.stereotype.Service;

/**
 * @author : hongbo
 * @create 2021-12-16-19:08
 **/

@Service
public class AnswerServiceImpl extends ServiceImpl<AnswerMapper, Answer> implements IAnswerService {
}
