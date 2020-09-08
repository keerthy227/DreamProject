package com.cognizant.dreams.entity;

import lombok.Data;

import java.util.List;
import java.util.Map;

@Data
public class MailDTO {


    private List<String> toBeSentMail;

    private String subject;

    private String text;

    private String fromMail;

    private List<Object> attachments;

    private Map<String, Object> props;



    public List<String> getToBeSentMail() {
        return toBeSentMail;
    }

    public void setToBeSentMail(List<String> toBeSentMail) {
        this.toBeSentMail = toBeSentMail;
    }
    public String getText() {
        return text;
    }

    @Override
    public String toString() {
        return "MailDTO{" +
                "toBeSentMail=" + toBeSentMail +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                ", fromMail='" + fromMail + '\'' +
                ", attachments=" + attachments +
                ", props=" + props +
                '}';
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getFromMail() {
        return fromMail;
    }

    public void setFromMail(String fromMail) {
        this.fromMail = fromMail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public List<Object> getAttachments() {
        return attachments;
    }

    public void setAttachments(List<Object> attachments) {
        this.attachments = attachments;
    }

    public Map<String, Object> getProps() {
        return props;
    }

    public void setProps(Map<String, Object> props) {
        this.props = props;
    }
}
