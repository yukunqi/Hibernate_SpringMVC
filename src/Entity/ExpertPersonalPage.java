package Entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 老师个人信息展示页面
 */
public class ExpertPersonalPage {

   //封面配图url
    private String page_picture;
    //个人介绍
    private String introduction;
    //咨询人数
    private int consult_number;
    //好评总数
    private Long good_comment_num;
    //评论总数
    private Long comment_total_number;
    //咨询评价的单个实体
    private Expert_comment_item item;
    //老师id
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long expert_id;
    //用户id
    private Long user_id;

    public ExpertPersonalPage() {
    }

    public ExpertPersonalPage(String introduction, String page_picture, int consult_number,Long user_id) {
        this.introduction = introduction;
        this.page_picture = page_picture;
        this.consult_number = consult_number;
        this.user_id=user_id;
    }

    public String getPage_picture() {
        return page_picture;
    }

    public void setPage_picture(String page_picture) {
        this.page_picture = page_picture;
    }

    public String getIntroduction() {
        return introduction;
    }

    public void setIntroduction(String introduction) {
        this.introduction = introduction;
    }

    public int getConsult_number() {
        return consult_number;
    }

    public void setConsult_number(int consult_number) {
        this.consult_number = consult_number;
    }

    public Long getGood_comment_num() {
        return good_comment_num;
    }

    public void setGood_comment_num(Long good_comment_num) {
        this.good_comment_num = good_comment_num;
    }

    public Long getComment_total_number() {
        return comment_total_number;
    }

    public void setComment_total_number(Long comment_total_number) {
        this.comment_total_number = comment_total_number;
    }

    public Expert_comment_item getItem() {
        return item;
    }

    public void setItem(Expert_comment_item item) {
        this.item = item;
    }

    public Long getExpert_id() {
        return expert_id;
    }

    public void setExpert_id(Long expert_id) {
        this.expert_id = expert_id;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
