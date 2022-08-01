package com.annauniv.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.math.BigInteger;
import java.util.Date;

@Document
public class DiscussionText {


    @Field
    private String Text;

    private Long discussionID;

    @Id
    private BigInteger userID;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;

    public DiscussionText( String text, Long discussionID, BigInteger userID, Date timeStamp) {
        this.Text = text;
        this.discussionID = discussionID;
        this.userID = userID;
        this.timeStamp = timeStamp;
    }


    public String getText() {
        return Text;
    }

    public void setText(String text) {
        Text = text;
    }

    public Long getDiscussionID() {
        return discussionID;
    }

    public void setDiscussionID(Long discussionID) {
        this.discussionID = discussionID;
    }

    public BigInteger getUserID() {
        return userID;
    }

    public void setUserID(BigInteger userID) {
        this.userID = userID;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
