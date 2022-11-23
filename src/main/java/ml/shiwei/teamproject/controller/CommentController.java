package ml.shiwei.teamproject.controller;

import ml.shiwei.teamproject.service.CommentService;
import ml.shiwei.teamproject.utils.identicon.Result;
import ml.shiwei.teamproject.utils.identicon.ResultCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

/**
 * @author: swl
 * @date: 2022/11/23
 * @description: Comment评论请求控制层
 */
@Controller
public class CommentController {
    @Autowired
    CommentService commentService;

    //根据用户id返回评论信息
    @ResponseBody
    @RequestMapping("/user/comment/list")
    public Result list(@RequestBody String userId){
        long id=Integer.parseInt(userId);
        List<Map<String,String>> list=commentService.getListByUserId(id);
        if(list!=null){
            return new Result(ResultCode.Success,list);
        }
        return new Result(ResultCode.PostEmptyOrEnterError);
    }

    //根据帖子id返回评论信息
    @ResponseBody
    @RequestMapping("/post/comment/view")
    public Result view(@RequestBody String postId){
        long id=Integer.parseInt(postId);
        List<Map<String,String>> list=commentService.getListByPostId(id);
        if(list!=null){
            return new Result(ResultCode.Success,list);
        }
        return new Result(ResultCode.CommentNotExistOrParameterError);
    }
}
