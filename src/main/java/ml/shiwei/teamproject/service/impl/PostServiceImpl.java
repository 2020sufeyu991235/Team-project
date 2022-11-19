package ml.shiwei.teamproject.service.impl;

import ml.shiwei.teamproject.dao.PostDao;
import ml.shiwei.teamproject.dao.UserDao;
import ml.shiwei.teamproject.entity.Post;
import ml.shiwei.teamproject.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.text.SimpleDateFormat;
import java.util.*;

//实现PostService接口
@Service
public class PostServiceImpl implements PostService {

    @Autowired
    private PostDao postDao;
    @Autowired
    private UserDao userDao;

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

    /**
     * 读取相应饭堂的帖子
     * @param canteen 饭堂字符串，如"一饭"
     * @return java.util.List 以Map<String,String>为元素的List列表，Map内装载着单个Post要传输的数据
     * @author swl
     **/
    @Override
    public List<Map<String, String>> getList(String canteen) {
        List<Map<String,String>> list = new ArrayList<>();
        List<Post> posts;
        if(!canteen.equals("all")) {
            posts = postDao.findByCanteen(canteen + "一楼", canteen + "二楼");
        }
        else{
            posts=postDao.findAll();
        }
        if (posts != null && posts.size() != 0) {
            for (Post post : posts) {
                Map<String, String> map = new HashMap<>();
                map.put("id", String.valueOf(post.getId()));
                long userId = post.getUserId();
                map.put("userId", String.valueOf(userId));
                map.put("userName", userDao.findById(userId).getUserName());
                map.put("title", post.getTitle());
                map.put("time", String.valueOf(post.getTime()));
                map.put("comments", String.valueOf(post.getComments()));
                map.put("commentTime", String.valueOf(post.getComment_time()));
                //标签
                map.put("food", post.getFood());
                map.put("price", String.valueOf(post.getPrice()));
                if(!canteen.equals("all")) {
                    map.put("shop", post.getShop());
                }
                else{
                    map.put("canteen",post.getCanteen());
                }
                list.add(map);
            }
            return list;
        }
        return null;
    }
}
