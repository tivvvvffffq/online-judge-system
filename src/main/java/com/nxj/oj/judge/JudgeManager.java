package com.nxj.oj.judge;

import com.nxj.oj.judge.strategy.DefaultJudgeStrategy;
import com.nxj.oj.judge.strategy.JavaJudgeStrategy;
import com.nxj.oj.judge.strategy.JudgeContext;
import com.nxj.oj.judge.strategy.JudgeStrategy;
import com.nxj.oj.model.dto.questionsubmit.JudgeInfo;
import com.nxj.oj.model.entity.QuestionSubmit;
import org.springframework.stereotype.Service;

/**
 * 判题管理（简化调用）
 */
@Service
public class JudgeManager {

    /**
     * 执行判题
     *
     * @param judgeContext
     * @return
     */
    JudgeInfo doJudge(JudgeContext judgeContext) {
        QuestionSubmit questionSubmit = judgeContext.getQuestionSubmit();
        String language = questionSubmit.getLanguage();
        JudgeStrategy judgeStrategy = new DefaultJudgeStrategy();
        if ("java".equals(language)) {
            judgeStrategy = new JavaJudgeStrategy();
        }
        return judgeStrategy.doJudge(judgeContext);
    }

}
