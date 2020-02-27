package com.Models.Entities;

import org.hibernate.annotations.OptimisticLockType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.ALL)
@Table(name="Bug",uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")
})
public class BugEntity implements Serializable {
    @Id
    @Column(name="ID",unique = true,nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name="product_id",nullable = false)
    private ProductEntity product;

    @ManyToOne
    @JoinColumn(name="component_id",nullable = false)
    private ComponentEntity component;

    @ManyToOne
    @JoinColumn(name="version_id",nullable = false)
    private VersionEntity prodVersion;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="BUG_ID")
    private Set<CommentEntity> comments;

    @Version
    @Column(name="VERSION",nullable = false)
    private int version;

    @Column(name="ASSIGNED_TO",length = 100)
    private String assigned_to;

    @Column(name="CREATOR",length = 100)
    private String creator;

    @Column(name="BLOCKED_BUGS")
    private int blocked_bugs;

    @Column(name="DEPEND_ON_BUGS")
    private int depend_on_bugs;

    @Column(name="CONFIRMED")
    private boolean confirmed;

    @Column(name="OPEN")
    private boolean open;

    @Column(name="CREATED",columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date creation_time;

    @Column(name="DUPLICATE")
    private boolean duplicate;

    @Column(name="LAST_CHANGED",columnDefinition = "DATETIME")
    @Temporal(TemporalType.TIMESTAMP)
    private Date last_changed_time;

    @Column(name="OP_SYS",length = 100)
    private String operating_system;

    @Column(name="PRIORITY",length = 100)
    private String priority;

    @Column(name="RESOLUTION",length = 100)
    private String resolution;

    @Column(name="SEVERITY",length = 100)
    private String severity;

    @Column(name="STATUS",length = 100)
    private String status;

    public BugEntity(){
        this.comments=new HashSet<CommentEntity>();
    }

    public BugEntity(Integer id, ProductEntity product, ComponentEntity component, VersionEntity prodVersion, Set<CommentEntity> comments, int version, String assigned_to, String creator, int blocked_bugs,
                     int depend_on_bugs, boolean confirmed, boolean open, Date creation_time, boolean duplicate, Date last_changed_time, String operating_system, String priority, String resolution, String severity, String status) {
        this.id = id;
        this.product = product;
        this.component = component;
        this.prodVersion = prodVersion;
        this.comments = comments;
        this.version = version;
        this.assigned_to = assigned_to;
        this.creator = creator;
        this.blocked_bugs = blocked_bugs;
        this.depend_on_bugs = depend_on_bugs;
        this.confirmed = confirmed;
        this.open = open;
        this.creation_time = creation_time;
        this.duplicate = duplicate;
        this.last_changed_time = last_changed_time;
        this.operating_system = operating_system;
        this.priority = priority;
        this.resolution = resolution;
        this.severity = severity;
        this.status = status;
    }

    public void appendComments(Collection<CommentEntity> comments)
    {
        for (CommentEntity comment:comments) {
            this.appendComment(comment);
        }
    }
    public void appendComment(CommentEntity comment){
        if(this.comments==null){
            this.comments=new HashSet<CommentEntity>();
        }
        this.comments.add(comment);
    }

    public String getOperating_system() {
        return operating_system;
    }

    public void setOperating_system(String operating_system) {
        this.operating_system = operating_system;
    }

    public String getPriority() {
        return priority;
    }

    public void setPriority(String priority) {
        this.priority = priority;
    }

    public String getResolution() {
        return resolution;
    }

    public void setResolution(String resolution) {
        this.resolution = resolution;
    }

    public String getSeverity() {
        return severity;
    }

    public void setSeverity(String severity) {
        this.severity = severity;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public boolean isDuplicate() {
        return duplicate;
    }

    public void setDuplicate(boolean duplicate) {
        this.duplicate = duplicate;
    }

    public Date getLast_changed_time() {
        return last_changed_time;
    }

    public void setLast_changed_time(Date last_changed_time) {
        this.last_changed_time = last_changed_time;
    }

    public Date getCreation_time() {
        return creation_time;
    }

    public void setCreation_time(Date creation_time) {
        this.creation_time = creation_time;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public boolean isConfirmed() {
        return confirmed;
    }

    public void setConfirmed(boolean confirmed) {
        this.confirmed = confirmed;
    }

    public int getDepend_on_bugs() {
        return depend_on_bugs;
    }

    public void setDepend_on_bugs(int depend_on_bugs) {
        this.depend_on_bugs = depend_on_bugs;
    }

    public int getBlocked_bugs() {
        return blocked_bugs;
    }

    public void setBlocked_bugs(int blocked_bugs) {
        this.blocked_bugs = blocked_bugs;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getAssigned_to() {
        return assigned_to;
    }

    public void setAssigned_to(String assigned_to) {
        this.assigned_to = assigned_to;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }

    public VersionEntity getProdVersion() {
        return prodVersion;
    }

    public void setProdVersion(VersionEntity prodVersion) {
        this.prodVersion = prodVersion;
    }

    public ComponentEntity getComponent() {
        return component;
    }

    public void setComponent(ComponentEntity component) {
        this.component = component;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Set<CommentEntity> getComments() {
        return comments;
    }

    public void setComments(Set<CommentEntity> comments) {
        this.comments = comments;
    }
}