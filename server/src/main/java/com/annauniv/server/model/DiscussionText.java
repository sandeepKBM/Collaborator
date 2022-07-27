package com.annauniv.server.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import java.util.Date;

@Document
public class DiscussionText {

    @Id
    private Long id;

    @Field
    private String Text;

    private Long discussionID;

    private Long userID;

    @Temporal(TemporalType.TIMESTAMP)
    private Date timeStamp;

    public DiscussionText(Long id, String text, Long discussionID, Long userID, Date timeStamp) {
        this.id = id;
        Text = text;
        this.discussionID = discussionID;
        this.userID = userID;
        this.timeStamp = timeStamp;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public Long getUserID() {
        return userID;
    }

    public void setUserID(Long userID) {
        this.userID = userID;
    }

    public Date getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(Date timeStamp) {
        this.timeStamp = timeStamp;
    }
}
