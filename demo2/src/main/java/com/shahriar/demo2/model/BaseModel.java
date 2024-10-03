package com.shahriar.demo2.model;

import jakarta.persistence.*;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;
@MappedSuperclass
@Data
public abstract class BaseModel implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @Column(updatable = false)
    private String createdBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;
    private String updatedBy;
    @Temporal(TemporalType.TIMESTAMP)
    private Date updatedAt;
    private boolean isActive = true;

    @PrePersist
    protected void setPreInsertDate() {
        this.createdAt = new Date();
        this.isActive = true;
    }
    @PreUpdate
    protected void setPreUpdateDate() {
        this.updatedAt = new Date();
    }
//    @PostPersist
//    public void setPostUpdateData(){
//        this.updatedAt = new Date();
//
//    }
}
