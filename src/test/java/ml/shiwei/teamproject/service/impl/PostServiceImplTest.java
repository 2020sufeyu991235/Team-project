package ml.shiwei.teamproject.service.impl;

import ml.shiwei.teamproject.service.PostService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class PostServiceImplTest {
    @Autowired
    PostService postService;

    @Test
    void getList() {
        List<Map<String,String>> list=postService.getListByCanteen("一饭");
        list.forEach(System.out::println);
    }
}