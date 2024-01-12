package com.nxj.oj.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.nxj.oj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.nxj.oj.model.entity.QuestionSubmit;
import com.nxj.oj.model.entity.User;

/**
 * 提交题目服务
 *
 * @author <a href="https://github.com/tivvvvffffq">nxj</a>
 * @from <a href="https://github.com/tivvvvffffq/online-judge-system">在线判题系统</a>
 */
public interface QuestionSubmitService extends IService<QuestionSubmit> {

    /**
     * 题目提交
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);


}

