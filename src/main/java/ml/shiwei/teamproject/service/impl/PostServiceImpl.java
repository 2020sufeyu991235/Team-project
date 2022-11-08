package ml.shiwei.teamproject.service.impl;

import ml.shiwei.teamproject.dao.PostDao;
import ml.shiwei.teamproject.entity.Post;
import ml.shiwei.teamproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
//实现PostService接口
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;

    @Override
    //发布帖子
    public void publish(Post post) {
        postDao.save(post);
    }
}
