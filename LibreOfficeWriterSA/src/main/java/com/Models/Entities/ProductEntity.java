package com.Models.Entities;
import org.hibernate.annotations.OptimisticLockType;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@org.hibernate.annotations.Entity(optimisticLock = OptimisticLockType.ALL)
@Table(name="Product",uniqueConstraints = {
        @UniqueConstraint(columnNames = "ID")
})
public class ProductEntity implements Serializable {
    @Id
    @Column(name="ID",unique = true,nullable = false)
    private Integer id;

    @Column(name="NAME",length = 100)
    private String name;

    @Version
    @Column(name="VERSION",nullable = false)
    private int version;

    @OneToMany(cascade = CascadeType.ALL,fetch = FetchType.LAZY)
    @JoinColumn(name="PRODUCT_ID")
    private Set<VersionEntity> versions;

    @OneToMany(cascade = CascadeType.ALL,fetch= FetchType.LAZY)
    @JoinColumn(name="PRODUCT_ID")
    private Set<ComponentEntity> components;


    public ProductEntity(){
        this.versions=new HashSet<VersionEntity>();
        this.components=new HashSet<ComponentEntity>();
    }

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

    public Set<VersionEntity> getVersions() {
        return versions;
    }

    public void setVersions(Set<VersionEntity> versions) {
        this.versions = versions;
    }

    public Set<ComponentEntity> getComponents() {
        return components;
    }

    public void setComponents(Set<ComponentEntity> components) {
        this.components = components;
    }
}
