package com.vaibhav.Agora.Common.Objects;

public class Email {

    private String senderEmail;
    private String receipientEmail;
    private String subject;
    private String body;

    public Email(String senderEmail, String receipientEmail, String subject, String body) {
        this.senderEmail = senderEmail;
        this.receipientEmail = receipientEmail;
        this.subject = subject;
        this.body = body;
    }

    public String getSenderEmail() {
        return senderEmail;
    }

    public void setSenderEmail(String senderEmail) {
        this.senderEmail = senderEmail;
    }

    public String getReceipientEmail() {
        return receipientEmail;
    }

    public void setReceipientEmail(String receipientEmail) {
        this.receipientEmail = receipientEmail;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
