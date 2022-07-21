package com.example.giaphong.Entities;

import javax.persistence.*;
import java.util.Date;

@MappedSuperclass
public abstract class BaseEntity {
    @Id // the hien la khoa chinh
    @GeneratedValue(strategy = GenerationType.IDENTITY) // AI
    @Column(name = "id")
    private Integer id;

    @Column(name ="created_by", nullable = true)
    private Integer createdBy;

    @Column(name ="updated_by", nullable = true)
    private Integer updatedBy;

    @Column(name ="created_date", nullable = true)
    private Date createdDate;

    @Column(name ="updated_date", nullable = true)
    private Date updatedDate;

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public Integer getCreatedBy() {
        return createdBy;
    }

    public void setCreatedBy(Integer createdBy) {
        this.createdBy = createdBy;
    }

    public Integer getUpdatedBy() {
        return updatedBy;
    }

    public void setUpdatedBy(Integer updatedBy) {
        this.updatedBy = updatedBy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getUpdatedDate() {
        return updatedDate;
    }

    public void setUpdatedDate(Date updatedDate) {
        this.updatedDate = updatedDate;
    }

}
