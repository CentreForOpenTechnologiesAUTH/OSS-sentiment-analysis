package com.Models.Entities;
import org.hibernate.annotations.OptimisticLockType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.ALL)
@Table(name="Comment",uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")
})
public class CommentEntity implements Serializable {
    @Id
    @Column(name="ID",unique = true,nullable = false)
    private Integer id;

    @ManyToOne
    private BugEntity bug;

    @Column(name="COMMENT_TEXT",length = 1000)
    private String text;

    @Column(name="COUNT_ORDER")
    private int count;

    @Column(name="CREATED",columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date created_time;

    @Column(name="CREATOR",length = 100)
    private String creator;

    @Column(name="BUG_CREATOR")
    private boolean bug_creator;

    @Column(name="BY_SYSTEM")
    private boolean system;

    @Version
    @Column(name="VERSION",nullable = false)
    private int version;

    public CommentEntity(){}

    public CommentEntity(Integer id, BugEntity bug, String text, int count, Date created_time, String creator, boolean bug_creator, boolean system) {
        this.id = id;
        this.bug = bug;
        this.text = text;
        this.count = count;
        this.created_time = created_time;
        this.creator = creator;
        this.bug_creator = bug_creator;
        this.system = system;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public Date getCreated_time() {
        return created_time;
    }

    public void setCreated_time(Date created_time) {
        this.created_time = created_time;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public boolean isBug_creator() {
        return bug_creator;
    }

    public void setBug_creator(boolean bug_creator) {
        this.bug_creator = bug_creator;
    }

    public boolean isSystem() {
        return system;
    }

    public void setSystem(boolean system) {
        this.system = system;
    }

    public BugEntity getBug() {
        return bug;
    }

    public void setBug(BugEntity bug) {
        this.bug = bug;
    }
}
