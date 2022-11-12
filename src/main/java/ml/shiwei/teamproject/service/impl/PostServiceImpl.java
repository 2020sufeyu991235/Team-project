package ml.shiwei.teamproject.service.impl;

import ml.shiwei.teamproject.dao.PostDao;
import ml.shiwei.teamproject.entity.Post;
import ml.shiwei.teamproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;

//实现PostService接口
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    /**
     * 初始化帖子Post参数并存储进数据库
     * @param post 已在前端加载部分参数的帖子Post实例
     * @param userId 用户id
     * @author tzf
     **/
    @Override
    public void publish(Post post,long userId) {
        //获取当前时间
        Date date = new Date(System.currentTimeMillis());
        post.setComment_time(date);
        post.setTime(date);
        post.setUserId(userId);
        post.setViews(0);
        post.setComments(0);
        post.setHeat(0);
        post.setLikes(0);
        post.setStep(0);
        postDao.save(post);
    }
}
