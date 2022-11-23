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

    //评论楼层
    private int floor;
    //上级评论楼层
    private int parentFloor;
    //帖子id
    private Long postId;
    //用户id
    private Long userId;
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

    public int getFloor() {
        return floor;
    }

    public void setFloor(int floor) {
        this.floor = floor;
    }

    public int getParentFloor() {
        return parentFloor;
    }

    public void setParentFloor(int parentFloor) {
        this.parentFloor = parentFloor;
    }

    public Long getPostId() {
        return postId;
    }

    public void setPostId(Long postId) {
        this.postId = postId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
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
