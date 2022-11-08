package ml.shiwei.teamproject.controller;

import io.jsonwebtoken.Claims;
import ml.shiwei.teamproject.entity.Post;
import ml.shiwei.teamproject.service.PostService;
import ml.shiwei.teamproject.utils.posting.UploadUtils;
import ml.shiwei.teamproject.utils.token.JwtUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.text.SimpleDateFormat;
import java.util.Date;

@RestController
public class PostController {

    @Autowired
    private PostService postService;

    @RequestMapping("/posting")
    //发新帖
    public void posting(@RequestBody Post post,@RequestHeader("token") String string){
        Date date = new Date();
        SimpleDateFormat dateFormat= new SimpleDateFormat("yyyy-MM-dd");
        post.setTime(java.sql.Date.valueOf(dateFormat.format(date)));
        post.setComment_time(java.sql.Date.valueOf(dateFormat.format(date)));
        post.setViews(0);
        post.setComments(0);
        post.setHeat(0);
        post.setLikes(0);
        post.setStep(0);
        Claims claims= JwtUtils.checkToken(string);
        long id= (int) claims.get("id");
        post.setUserId(id);
        postService.publish(post);
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
