package ml.shiwei.teamproject.controller;

import ml.shiwei.teamproject.dao.PostDao;
import ml.shiwei.teamproject.entity.Post;
import ml.shiwei.teamproject.utils.posting.UploadUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@RestController
public class PostingController {

    @Resource
    private PostDao postDao;

    @RequestMapping("/posting")
    //发新帖
    public void posting(@RequestBody Post post){
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        post.setTime(java.sql.Date.valueOf(dateFormat.format(date)));
        post.setComment_time(java.sql.Date.valueOf(dateFormat.format(date)));
        post.setViews(0);
        post.setComments(0);
        post.setHeat(0);
        post.setLikes(0);
        post.setStep(0);
        post.setUser_id(123L);
        postDao.save(post);
    //    System.out.println(post.toString());
    }

    @PostMapping("/posting/upload")
    public String uploadImage(@RequestParam(value = "file") MultipartFile multipartFile){
        if (multipartFile.isEmpty()){
            return "文件有误！";
        }
        return UploadUtils.uploadImage(multipartFile);
    }
}
