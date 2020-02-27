package com.Models.Entities;
import org.hibernate.annotations.OptimisticLockType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.ALL)
@Table(name="Component",uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")
})
public class ComponentEntity {
    @Id
    @Column(name="ID",unique = true,nullable = false)
    private Integer id;

    @Column(name="NAME",length = 100)
    private String name;

    @Column(name="ACTIVE")
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

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public int getVersion() {
        return version;
    }

    public void setVersion(int version) {
        this.version = version;
    }
}
