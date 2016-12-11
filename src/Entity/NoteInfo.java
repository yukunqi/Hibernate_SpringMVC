package Entity;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 问答信息实体类
 */
public class NoteInfo {

    //帖子id
    private Long id;
    //帖子标题
    private String note_title;
    //帖子回答
    private String note_answer;
    //回答时间
    private String comment_date;
    //评论数
    private int comment_num;
    //点赞数
    private int good_num;

    private static SimpleDateFormat format;
    static {
        format=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
    }

    public NoteInfo() {
    }

    public NoteInfo(Long id, String note_title, String note_answer, Date comment_date, int comment_num, int good_num) {
        this.id = id;
        this.note_title = note_title;
        this.note_answer = note_answer;
        this.comment_date = format.format(comment_date);
        this.comment_num = comment_num;
        this.good_num = good_num;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNote_title() {
        return note_title;
    }

    public void setNote_title(String note_title) {
        this.note_title = note_title;
    }

    public String getNote_answer() {
        return note_answer;
    }

    public void setNote_answer(String note_answer) {
        this.note_answer = note_answer;
    }

    public int getComment_num() {
        return comment_num;
    }

    public void setComment_num(int comment_num) {
        this.comment_num = comment_num;
    }

    public int getGood_num() {
        return good_num;
    }

    public void setGood_num(int good_num) {
        this.good_num = good_num;
    }

    public String getComment_date() {
        return comment_date;
    }

    public void setComment_date(String comment_date) {
        this.comment_date = comment_date;
    }
}
