package ml.shiwei.teamproject.service.impl;

import ml.shiwei.teamproject.dao.CommentDao;
import ml.shiwei.teamproject.dao.PostDao;
import ml.shiwei.teamproject.dao.UserDao;
import ml.shiwei.teamproject.entity.Comment;
import ml.shiwei.teamproject.service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author: swl
 * @date: 2022/11/23
 * @description:
 */
@Service
public class CommentServiceImpl implements CommentService {
    @Autowired
    CommentDao commentDao;
    @Autowired
    UserDao userDao;
    @Autowired
    PostDao postDao;

    /**
     * 根据用户id获取评论
     * @param userId 用户id
     * @return java.util.List 评论list列表
     * @author swl
     **/
    @Override
    public List<Map<String, String>> getListByUserId(long userId) {
        List<Comment> comments=commentDao.findByUserIdOrderByIdDesc(userId);
        List<Map<String,String>> list=new ArrayList<>();

        if(comments!=null&&!comments.isEmpty()){
            for(Comment comment:comments){
                Map<String,String> map=new HashMap<>();
                long postId=comment.getPostId();
                map.put("title",postDao.findById(postId).getTitle());
                map.put("postId", String.valueOf(postId));
                map.put("commentId",String.valueOf(comment.getId()));
                map.put("time",String.valueOf(comment.getTime()));
                map.put("content",comment.getContent());
                map.put("likes",String.valueOf(comment.getLikes()));
                map.put("step",String.valueOf(comment.getStep()));
                list.add(map);
            }
            return list;
        }
        return null;
    }

    /**
     * 根据帖子id获取评论
     * @param postId 帖子id
     * @return java.util.List 评论list列表
     * @author swl
     **/
    @Override
    public List<Map<String, String>> getListByPostId(long postId) {
        List<Comment> comments=commentDao.findByPostIdOrderByIdAsc(postId);
        List<Map<String,String>> list=new ArrayList<>();

        if(comments!=null&&!comments.isEmpty()){
            for(Comment comment:comments){
                Map<String,String> map=new HashMap<>();
                map.put("floor",String.valueOf(comment.getFloor()));
                map.put("content",comment.getContent());
                map.put("likes",String.valueOf(comment.getLikes()));
                map.put("parentFloor",String.valueOf(comment.getParentFloor()));
                map.put("step",String.valueOf(comment.getStep()));
                map.put("time",String.valueOf(comment.getTime()));
                long userId=comment.getUserId();
                map.put("userName",userDao.findById(userId).getUserName());
                list.add(map);
            }
            return list;
        }
        return null;
    }
}
