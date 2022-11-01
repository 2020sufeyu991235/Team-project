package ml.shiwei.teamproject.entity;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;
import java.util.Date;

/**
 * @author: swl
 * @date: 2022/10/31
 * @description: token数据表
 */
@Entity
@Table(name="token")
public class Token implements Serializable {
    private static final long serialVersionUID = -2496721970528556407L;

    @Id
    private Date date;

    //令牌字符串
    private String string;

    public Token() {
    }

    public Token(Date date, String string) {
        this.date = date;
        this.string = string;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getString() {
        return string;
    }

    public void setString(String string) {
        this.string = string;
    }
}
