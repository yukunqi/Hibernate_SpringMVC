package Entity;

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
    //文章总数
    private Long article_total_number;
    //咨询评价的单个实体
    private Expert_comment_item item;
    //文章
    private Article article;

    public ExpertPersonalPage() {
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

    public Long getArticle_total_number() {
        return article_total_number;
    }

    public void setArticle_total_number(Long article_total_number) {
        this.article_total_number = article_total_number;
    }

    public Expert_comment_item getItem() {
        return item;
    }

    public void setItem(Expert_comment_item item) {
        this.item = item;
    }

    public Article getArticle() {
        return article;
    }

    public void setArticle(Article article) {
        this.article = article;
    }
}
