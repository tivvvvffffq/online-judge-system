package com.nxj.oj.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.nxj.oj.common.ErrorCode;
import com.nxj.oj.exception.BusinessException;
import com.nxj.oj.mapper.QuestionSubmitMapper;
import com.nxj.oj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.nxj.oj.model.entity.Question;
import com.nxj.oj.model.entity.QuestionSubmit;
import com.nxj.oj.model.entity.User;
import com.nxj.oj.model.enums.QuestionSubmitLanguageEnum;
import com.nxj.oj.model.enums.QuestionSubmitStatusEnum;
import com.nxj.oj.service.QuestionService;
import com.nxj.oj.service.QuestionSubmitService;
import com.nxj.oj.service.UserService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 提交题目服务实现
 *
 * @author <a href="https://github.com/tivvvvffffq">nxj</a>
 * @from <a href="https://github.com/tivvvvffffq/online-judge-system">在线判题系统</a>
 */
@Service
public class QuestionSubmitServiceImpl extends ServiceImpl<QuestionSubmitMapper, QuestionSubmit>
    implements QuestionSubmitService{
    @Resource
    private QuestionService questionService;

    @Resource
    private UserService userService;

    /**
     * 题目提交
     * @param questionSubmitAddRequest
     * @param loginUser
     * @return
     */
    @Override
    public long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser) {
        String language = questionSubmitAddRequest.getLanguage();
        QuestionSubmitLanguageEnum languageEnum = QuestionSubmitLanguageEnum.getEnumByValue(language);
        if (languageEnum == null) {
            throw new BusinessException(ErrorCode.PARAMS_ERROR, "编程语言错误");
        }
        long questionId = questionSubmitAddRequest.getQuestionId();
        // 判断实体是否存在，根据类别获取实体
        Question question = questionService.getById(questionId);
        if (question == null) {
            throw new BusinessException(ErrorCode.NOT_FOUND_ERROR);
        }
        // 是否已提交题目
        long userId = loginUser.getId();
        // 每个用户串行提交题目
        QuestionSubmit questionSubmit = new QuestionSubmit();
        questionSubmit.setUserId(userId);
        questionSubmit.setQuestionId(questionId);
        questionSubmit.setCode(questionSubmitAddRequest.getCode());
        questionSubmit.setLanguage(language);
        // 设置初始状态
        questionSubmit.setStatus(QuestionSubmitStatusEnum.WAITING.getValue());
        questionSubmit.setJudgeInfo("{}");

        boolean save = this.save(questionSubmit);
        if (!save) {
            throw new BusinessException(ErrorCode.SYSTEM_ERROR, "题目提交失败");
        }
        return questionSubmit.getId();
    }
}




