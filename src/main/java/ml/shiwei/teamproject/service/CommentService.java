package ml.shiwei.teamproject.service;

import java.util.List;
import java.util.Map;

/**
 * @author: swl
 * @date: 2022/11/22
 * @description: 评论业务逻辑接口
 */
public interface CommentService {
    /**
     * 根据用户id获取评论
     * @param userId 用户id
     * @return java.util.List 评论list列表
     * @author swl
     **/
    List<Map<String,String>> getListByUserId(long userId);

    /**
     * 根据帖子id获取评论
     * @param postId 帖子id
     * @return java.util.List 评论list列表
     * @author swl
     **/
    List<Map<String,String>> getListByPostId(long postId);
}
