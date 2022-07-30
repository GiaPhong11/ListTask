package com.example.giaphong.Entities;

import javax.persistence.*;

@Entity
@Table(name = "tbl_tasks")
public class TaskEntity extends BaseEntity {

    @Column(name = "title", length = 1000, nullable = false)
    private String title;


    @Column(name = "content", nullable = false, columnDefinition = "LONGTEXT")
    private String content;

    @Column(name = "status",length = 50 , nullable = false)
    private String status;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "user_id") // Tên khóa phụ trong bảng Tasks
    private UserEntity userEntity; // đây là cái mappedBy

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
