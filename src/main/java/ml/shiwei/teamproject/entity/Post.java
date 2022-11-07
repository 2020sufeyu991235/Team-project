package ml.shiwei.teamproject.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: swl
 * @date: 2022/10/30
 * @description: 用于存储发帖的数据表
 */
@Entity
@Table(name="post")
public class Post implements Serializable {

    private static final long serialVersionUID = -5926732125517929L;

    @Id
    @GeneratedValue
    //帖子id
    private Long id;

    //发布用户id
    private Long userId;
    //标题
    private String title;
    //内容
    private String content;
    //图片存储路径
    private String path;
    //发布时间
    private Date time;
    //最后评论时间
    private Date comment_time;
    //浏览次数
    private int views;
    //评论数
    private int comments;
    //热度
    private int heat;
    //点赞量
    private int likes;
    //踩
    private int step;
    //菜品
    private String food;
    //价格
    private float price;
    //店铺
    private String shop;
    //饭堂
    private String canteen;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
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

    public Date getTime() {
        return time;
    }

    public void setTime(Date time) {
        this.time = time;
    }

    public Date getComment_time() {
        return comment_time;
    }

    public void setComment_time(Date comment_time) {
        this.comment_time = comment_time;
    }

    public int getViews() {
        return views;
    }

    public void setViews(int views) {
        this.views = views;
    }

    public int getComments() {
        return comments;
    }

    public void setComments(int comments) {
        this.comments = comments;
    }

    public int getHeat() {
        return heat;
    }

    public void setHeat(int heat) {
        this.heat = heat;
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

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    public float getPrice() {
        return price;
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public String getShop() {
        return shop;
    }

    public void setShop(String shop) {
        this.shop = shop;
    }

    public String getCanteen() {
        return canteen;
    }

    public void setCanteen(String canteen) {
        this.canteen = canteen;
    }
}
