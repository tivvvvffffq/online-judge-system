package com.nxj.oj.model.dto.postfavour;

import com.nxj.oj.common.PageRequest;
import com.nxj.oj.model.dto.post.PostQueryRequest;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

/**
 * 帖子收藏查询请求
 *
 * @author <a href="https://github.com/tivvvvffffq">nxj</a>
 * @from <a href="https://github.com/tivvvvffffq/online-judge-system">在线判题系统</a>
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class PostFavourQueryRequest extends PageRequest implements Serializable {

    /**
     * 帖子查询请求
     */
    private PostQueryRequest postQueryRequest;

    /**
     * 用户 id
     */
    private Long userId;

    private static final long serialVersionUID = 1L;
}