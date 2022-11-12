package ml.shiwei.teamproject.service;

import ml.shiwei.teamproject.entity.Post;

import java.util.List;
import java.util.Map;

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

    /**
     * 读取相应饭堂的帖子
     * @param canteen 饭堂字符串，如"一饭"
     * @return java.util.List 以Map<String,String>为元素的List列表，Map内装载着单个Post要传输的数据
     * @author swl
     **/
    List<Map<String,String>> getList(String canteen);
}
