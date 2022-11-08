package ml.shiwei.teamproject.post;

import ml.shiwei.teamproject.dao.PostDao;
import ml.shiwei.teamproject.entity.Post;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;


import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author tzf
 * @date 2022/11/4
 * @Description
 */
@RunWith(SpringRunner.class)
@SpringBootTest
class PostTest {

    @Autowired
    private PostDao postDao;

    @Test
    void postingTest(){
        Post post=new Post();
        post.setTitle("真香");
        post.setFood("鸡腿饭");
        post.setCanteen("sanfan2");
        post.setShop("麻辣香锅旁边");
        post.setPrice(13);
        post.setContent("鸡腿真大");
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        post.setTime(java.sql.Date.valueOf(dateFormat.format(date)));
        post.setComment_time(java.sql.Date.valueOf(dateFormat.format(date)));
        post.setViews(0);
        post.setComments(0);
        post.setHeat(0);
        post.setLikes(0);
        post.setStep(0);
        post.setUserId(123L);
        post.setPath("//");
        //插入数据
        //postDao.findAll()
        postDao.save(post);
        System.out.println(postDao.findAll());
    }

    @Test
    void getPath() {
        String filepath=System.getProperty("user.dir")+"\\src\\main\\resources\\static\\img\\";
        System.out.println(filepath.replace("\\","/"));
    }
}
