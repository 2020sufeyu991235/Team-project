package ml.shiwei.teamproject.dao;

import ml.shiwei.teamproject.entity.Post;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostDaoTest {
    @Autowired
    PostDao postDao;

    @Test
    void findByCanteen(){
        List<Post> list=postDao.findByCanteen("一饭一楼","一饭二楼");
        list.forEach(System.out::println);
    }
}