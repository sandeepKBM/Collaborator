package com.annauniv.server.model;



import com.annauniv.server.authority.UserAccountDesignation;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
public class DiscussionIndex {

    @Id
    private Long id;
    
    private Long parentId;

    private Long discussionId;

    private String discussionName;

    private String description;

    @Temporal(TemporalType.TIMESTAMP)

    private Date creationDateTime;

    @Enumerated(EnumType.STRING)
    private UserAccountDesignation AccessClass;

    public DiscussionIndex(Long id, Long discussionId, String discussionName, String description, Date creationDateTime, UserAccountDesignation accessClass) {
        this.id = id;
        this.discussionId = discussionId;
        this.discussionName = discussionName;
        this.description = description;
        this.creationDateTime = creationDateTime;
        this.AccessClass = accessClass;
    }

    public DiscussionIndex(Long id, Long parentId, Long discussionId, String discussionName, String description, Date creationDateTime, UserAccountDesignation accessClass) {
        this.id = id;
        this.parentId = parentId;
        this.discussionId = discussionId;
        this.discussionName = discussionName;
        this.description = description;
        this.creationDateTime = creationDateTime;
        AccessClass = accessClass;
    }

    public DiscussionIndex(Long discussionId, String discussionName, String description, UserAccountDesignation accessClass) {
        this.discussionId = discussionId;
        this.discussionName = discussionName;
        this.description = description;
        this.AccessClass = accessClass;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getParentId() { return parentId; }

    public void setParentId(Long parentId) { this.parentId = parentId; }

    public Long getDiscussionId() {
        return discussionId;
    }

    public void setDiscussionId(Long discussionId) {
        this.discussionId = discussionId;
    }

    public String getDiscussionName() {
        return discussionName;
    }

    public void setDiscussionName(String discussionName) {
        this.discussionName = discussionName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getCreationDateTime() {
        return creationDateTime;
    }

    public void setCreationDateTime(Date creationDateTime) {
        this.creationDateTime = creationDateTime;
    }

    public UserAccountDesignation getAccessClass() {
        return AccessClass;
    }

    public void setAccessClass(UserAccountDesignation accessClass) {
        AccessClass = accessClass;
    }
}
