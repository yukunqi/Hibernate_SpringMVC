package Entity;


import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 咨询列表中的每个list_item的信息
 */

public class ExpertsInfo {

    //封面配图
    private String imageUrl;
    //名字
    private String expert_name;
    //学院
    private String expert_college;
    //心理宣言
    private String motto;
    //咨询过的人数
    private int consult_number;
    //好评率
    private double good_comment;
    //老师id
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private Long expert_id;
    //老师用户 id
    private Long user_id;
    //用户类型名称
    private String user_type_name;

    public ExpertsInfo() {
    }

    public ExpertsInfo(String imageUrl, String expert_name, String expert_college, String motto,int consult_number,String user_type_name,Long user_id) {
        this.imageUrl = imageUrl;
        this.expert_name = expert_name;
        this.expert_college = expert_college;
        this.motto = motto;
        this.consult_number = consult_number;
        this.user_type_name=user_type_name;
        this.user_id=user_id;
    }

    public ExpertsInfo(String imageUrl, String expert_name, String expert_college, String motto,int consult_number,Long expert_id,String user_type_name,Long user_id) {
        this.imageUrl = imageUrl;
        this.expert_name = expert_name;
        this.expert_college = expert_college;
        this.motto = motto;
        this.consult_number = consult_number;
        this.expert_id=expert_id;
        this.user_type_name=user_type_name;
        this.user_id=user_id;
    }

    public Long getExpert_id() {
        return expert_id;
    }

    public void setExpert_id(Long expert_id) {
        this.expert_id = expert_id;
    }

    public ExpertsInfo(String expert_name) {
        this.expert_name = expert_name;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getExpert_name() {
        return expert_name;
    }

    public void setExpert_name(String expert_name) {
        this.expert_name = expert_name;
    }

    public String getExpert_college() {
        return expert_college;
    }

    public void setExpert_college(String expert_college) {
        this.expert_college = expert_college;
    }

    public String getMotto() {
        return motto;
    }

    public void setMotto(String motto) {
        this.motto = motto;
    }

    public int getConsult_number() {
        return consult_number;
    }

    public void setConsult_number(int consult_number) {
        this.consult_number = consult_number;
    }

    public double getGood_comment() {
        return good_comment;
    }

    public void setGood_comment(double good_comment) {
        this.good_comment = good_comment;
    }

    public String getUser_type_name() {
        return user_type_name;
    }

    public void setUser_type_name(String user_type_name) {
        this.user_type_name = user_type_name;
    }

    public Long getUser_id() {
        return user_id;
    }

    public void setUser_id(Long user_id) {
        this.user_id = user_id;
    }
}
