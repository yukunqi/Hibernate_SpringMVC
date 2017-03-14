package Entity;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * 聊天记录实体类
 */
@JsonInclude(JsonInclude.Include.NON_NULL)
public class ChatLogsEntity {
    //内容
    private String content;
    //发送者
    private String sender;
    //接受者
    private String receiver;


    public ChatLogsEntity() {
    }

    public ChatLogsEntity(String content, String sender) {
        this.content = content;
        this.sender = sender;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReceiver(String receiver) {
        this.receiver = receiver;
    }
}
