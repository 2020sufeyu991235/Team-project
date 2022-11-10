package ml.shiwei.teamproject.service;

import ml.shiwei.teamproject.entity.Post;

/**
 * @author tzf
 * @date 2022/11/7
 * @Description
 */
public interface PostService {
    /**
     * 初始化帖子Post参数并存储进数据库
     * @param post 已在前端加载部分参数的帖子Post实例
     * @param userId 用户id
     * @author tzf
     **/
    void publish(Post post,long userId);
}
