package Entity;

/**
 * 计算老师好评率百分比的模型
 */
public class Expert_percent {

    private Long expert_id;
    private Long totalComment;
    private Long goodComment;
    private int precent;

    public Expert_percent() {
    }

    public Expert_percent(Long expert_id) {
        this.expert_id = expert_id;
    }

    public Expert_percent(Long expert_id, Long totalComment) {
        this.expert_id = expert_id;
        this.totalComment = totalComment;
    }

    public Long getTotalComment() {
        return totalComment;
    }

    public void setTotalComment(Long totalComment) {
        this.totalComment = totalComment;
    }

    public Long getGoodComment() {
        return goodComment;
    }

    public void setGoodComment(Long goodComment) {
        this.goodComment = goodComment;
    }

    public int getPrecent() {
        return precent;
    }

    public void setPrecent(int precent) {
        this.precent = precent;
    }

    public Long getExpert_id() {
        return expert_id;
    }

    public void setExpert_id(Long expert_id) {
        this.expert_id = expert_id;
    }
}
