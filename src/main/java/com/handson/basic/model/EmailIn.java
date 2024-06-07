package com.handson.basic.model;

import java.io.Serializable;

public class EmailIn implements Serializable {

    private String subject;

    private String content;

    private String toAddress;

    public EmailIn(){}

    public EmailIn(String subject, String content, String toAddress) {
        this.subject = subject;
        this.content = content;
        this.toAddress = toAddress;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getToAddress() {
        return toAddress;
    }

    public void setToAddress(String toAddress) {
        this.toAddress = toAddress;
    }

}
