package Entity;


import javax.persistence.*;

/**
 * 聊天记录实体类
 */
@Entity
@Table(name = "of_chatlogs",schema = "xinli")
public class ChatLogs {

    private long message_id;

    private String session_jid;

    private String sender;

    private String receiver;

    private String createDate;

    private int length;

    private String content;

    private String detail;

    private int state;

    public ChatLogs() {
    }

    public ChatLogs(long message_id) {
        this.message_id = message_id;
    }

    @GeneratedValue
    @Id
    public long getMessage_id() {
        return message_id;
    }

    public void setMessage_id(long message_id) {
        this.message_id = message_id;
    }
    @Column(name = "session_jid")
    public String getSession_jid() {
        return session_jid;
    }

    public void setSession_jid(String session_jid) {
        this.session_jid = session_jid;
    }
    @Column(name = "sender")
    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
    @Column(name = "receiver")
    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
    @Column(name = "createDate")
    public String getCreateDate() {
        return createDate;
    }

    public void setCreateDate(String createDate) {
        this.createDate = createDate;
    }
    @Column(name = "length")
    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }
    @Column(name = "content")
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
    @Column(name = "detail")
    public String getDetail() {
        return detail;
    }

    public void setDetail(String detail) {
        this.detail = detail;
    }
    @Column(name = "state")
    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
