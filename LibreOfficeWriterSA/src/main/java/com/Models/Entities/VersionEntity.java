package com.Models.Entities;

import org.hibernate.annotations.OptimisticLockType;


import javax.persistence.*;
import java.io.Serializable;

@Entity
@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.ALL)
@Table(name="Version",uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID"),
        @UniqueConstraint(columnNames = "NAME")
})
public class VersionEntity implements Serializable {

    @Id
    @Column(name="ID",unique = true,nullable = false)
    private Integer id;

    @Column(name="NAME",unique = true,nullable = false,length = 100)
    private String name;

    @Column(name="ACTIVE",nullable = false)
    private Boolean isActive;

    @Version
    @Column(name="VERSION",nullable = false)
    private int version;

    @ManyToOne
    private ProductEntity product;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getIsActive() {
        return isActive;
    }

    public void setIsActive(Boolean isActive) {
        this.isActive = isActive;
    }
}
