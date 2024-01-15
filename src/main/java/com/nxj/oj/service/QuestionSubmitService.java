package com.nxj.oj.service;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.IService;
import com.nxj.oj.model.dto.question.QuestionQueryRequest;
import com.nxj.oj.model.dto.questionsubmit.QuestionSubmitAddRequest;
import com.nxj.oj.model.dto.questionsubmit.QuestionSubmitQueryRequest;
import com.nxj.oj.model.entity.Question;
import com.nxj.oj.model.entity.QuestionSubmit;
import com.nxj.oj.model.entity.User;
import com.nxj.oj.model.vo.QuestionSubmitVO;
import com.nxj.oj.model.vo.QuestionVO;

import javax.servlet.http.HttpServletRequest;

/**
 * 提交题目服务
 *
 * @author <a href="https://github.com/tivvvvffffq">nxj</a>
 * @from <a href="https://github.com/tivvvvffffq/online-judge-system">在线判题系统</a>
 */
public interface QuestionSubmitService extends IService<QuestionSubmit> {
    /**
     * 题目提交
     *
     * @param questionSubmitAddRequest 题目提交信息
     * @param loginUser
     * @return
     */
    long doQuestionSubmit(QuestionSubmitAddRequest questionSubmitAddRequest, User loginUser);

    /**
     * 获取查询条件
     *
     * @param questionSubmitQueryRequest
     * @return
     */
    QueryWrapper<QuestionSubmit> getQueryWrapper(QuestionSubmitQueryRequest questionSubmitQueryRequest);

    /**
     * 获取题目封装
     *
     * @param questionSubmit
     * @param loginUser
     * @return
     */
    QuestionSubmitVO getQuestionSubmitVO(QuestionSubmit questionSubmit, User loginUser);

    /**
     * 分页获取题目封装
     *
     * @param questionSubmitPage
     * @param loginUser
     * @return
     */
    Page<QuestionSubmitVO> getQuestionSubmitVOPage(Page<QuestionSubmit> questionSubmitPage, User loginUser);
}

