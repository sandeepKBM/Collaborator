package com.annauniv.server.model;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
public class Newsletter {

    @Id
    private Long id;
    private String text;
    private String type;
    private String moreInfo;
    private String link;
    @Temporal(TemporalType.TIMESTAMP)
    private Date creationDateTime;

    //@Enumerated(EnumType.STRING)
    //private UserAccountDesignation AccessClass;

    public Newsletter(Long id, String text, String type, String moreInfo, String link, Date creationDateTime/*, UserAccountDesignation accessClass*/) {
        this.id = id;
        this.text = text;
        this.type = type;
        this.moreInfo = moreInfo;
        this.link = link;
        this.creationDateTime = creationDateTime;
        //this.AccessClass = accessClass;
    }

    /*public Newsletter(Long discussionId, String discussionName, String description, UserAccountDesignation accessClass) {
        this.discussionId = discussionId;
        this.discussionName = discussionName;
        this.description = description;
        this.AccessClass = accessClass;
    }*/

    public void setId(Long id) {
        this.id = id;
    }

    public void setText(String text) {
        this.text = text;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setMoreInfo(String moreInfo) {
        this.moreInfo = moreInfo;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public void setCreationDateTime(Date creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public Long getId() {
        return id;
    }

    public String getText() {
        return text;
    }

    public String getType() {
        return type;
    }

    public String getMoreInfo() {
        return moreInfo;
    }

    public String getLink() {
        return link;
    }

    public Date getCreationDateTime() {
        return creationDateTime;
    }
}
