package com.annauniv.server.model;



import com.annauniv.server.authority.UserAccountDesignation;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@NoArgsConstructor
public class Newsletter {

    @Id
    private int sNo;
    private String title;
    private String department;
    private String lastDate;
    private String link;

    @Temporal(TemporalType.TIMESTAMP)

    private Date creationDateTime;

    @Enumerated(EnumType.STRING)
    private UserAccountDesignation AccessClass;

    public Newsletter(int sNo, String title, String department, String lastDate, String link) {
        this.sNo = sNo;
        this.title = title;
        this.department = department;
        this.lastDate = lastDate;
        this.link = link;
    }

    public int getsNo() {
        return sNo;
    }

    public void setsNo(int sNo) {
        this.sNo = sNo;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getLastDate() {
        return lastDate;
    }

    public void setLastDate(String lastDate) {
        this.lastDate = lastDate;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }
}
