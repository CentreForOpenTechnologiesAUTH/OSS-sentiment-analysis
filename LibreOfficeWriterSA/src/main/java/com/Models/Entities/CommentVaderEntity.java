package com.Models.Entities;

import org.hibernate.annotations.OptimisticLockType;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.ALL)
@Table(name="commentVSA")
public class CommentVaderEntity implements Serializable {
    public CommentVaderEntity() {
    }

    public CommentVaderEntity(Integer id,CommentEntity comment, float negative, float neutral, float positive, float compound) {
        this.id = id;
        this.comment=comment;
        this.negative = negative;
        this.neutral = neutral;
        this.positive = positive;
        this.compound = compound;
    }

    @Id
    private Integer id;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    private CommentEntity comment;

    @Column(name="NEGATIVE")
    private float negative;

    @Column(name="NEUTRAL")
    private float neutral;

    @Column(name="POSITIVE")
    private float positive;

    @Column(name="COMPOUND")
    private float compound;

    @Version
    @Column(name="VERSION",nullable = false)
    private int version;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public float getNegative() {
        return negative;
    }

    public void setNegative(float negative) {
        this.negative = negative;
    }

    public float getNeutral() {
        return neutral;
    }

    public void setNeutral(float neutral) {
        this.neutral = neutral;
    }

    public float getPositive() {
        return positive;
    }

    public void setPositive(float positive) {
        this.positive = positive;
    }

    public float getCompound() {
        return compound;
    }

    public void setCompound(float compound) {
        this.compound = compound;
    }
}
