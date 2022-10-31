package ml.shiwei.teamproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.sql.Time;

/**
 * @author: swl
 * @date: 2022/10/30
 * @description: 存储评论的数据表
 */
@Entity
@Table(name="comment")
public class Comment implements Serializable {

    private static final long serialVersionUID = 6456632981401649352L;
    @Id
    @GeneratedValue
    private Long id;

    //上级评论id
    private Long parent_id;
    //帖子id
    private Long post_id;
    //用户id
    private Long user_id;
    //内容
    private String content;
    //图片路径
    private String path;
    //发布时间
    private Time time;
    //点赞量
    private int likes;
    //踩
    private int step;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParent_id() {
        return parent_id;
    }

    public void setParent_id(Long parent_id) {
        this.parent_id = parent_id;
    }

    public Long getPost_id() {
        return post_id;
    }

    public void setPost_id(Long post_id) {
        this.post_id = post_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public Time getTime() {
        return time;
    }

    public void setTime(Time time) {
        this.time = time;
    }

    public int getLikes() {
        return likes;
    }

    public void setLikes(int likes) {
        this.likes = likes;
    }

    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }
}
