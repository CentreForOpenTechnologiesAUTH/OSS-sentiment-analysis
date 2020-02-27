package com.Models.Entities;

import org.hibernate.annotations.OptimisticLockType;

import javax.persistence.*;

@Entity
@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.ALL)
@Table(name="commentMC")
public class CommentMCEntity {
    public CommentMCEntity() {
    }

    public CommentMCEntity(Integer id, CommentEntity comment, String score, String agreement, String subjectivity, String irony, int confidence, int sentencesCount) {
        this.id = id;
        this.comment = comment;
        this.score = score;
        this.agreement = agreement;
        this.subjectivity = subjectivity;
        this.irony = irony;
        this.confidence = confidence;
        this.sentencesCount = sentencesCount;
    }

    @Id
    private Integer id;

    @OneToOne(fetch=FetchType.LAZY)
    @MapsId
    private CommentEntity comment;

    @Column(name="SCORE")
    private String score;
    @Column(name="AGREEMENT")
    private String agreement;
    @Column(name="SUBJECTIVITY")
    private String subjectivity;
    @Column(name="IRONY")
    private String irony;
    @Column(name="CONFIDENCE")
    private int confidence;
    @Column(name="SENTENCES")
    private int sentencesCount;

    @Version
    @Column(name="VERSION")
    private int version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public CommentEntity getComment() {
        return comment;
    }

    public void setComment(CommentEntity comment) {
        this.comment = comment;
    }

    public String getScore() {
        return score;
    }

    public void setScore(String score) {
        this.score = score;
    }

    public String getAgreement() {
        return agreement;
    }

    public void setAgreement(String agreement) {
        this.agreement = agreement;
    }

    public String getSubjectivity() {
        return subjectivity;
    }

    public void setSubjectivity(String subjectivity) {
        this.subjectivity = subjectivity;
    }

    public String getIrony() {
        return irony;
    }

    public void setIrony(String irony) {
        this.irony = irony;
    }

    public int getConfidence() {
        return confidence;
    }

    public void setConfidence(int confidence) {
        this.confidence = confidence;
    }

    public int getSentencesCount() {
        return sentencesCount;
    }

    public void setSentencesCount(int sentencesCount) {
        this.sentencesCount = sentencesCount;
    }
}
