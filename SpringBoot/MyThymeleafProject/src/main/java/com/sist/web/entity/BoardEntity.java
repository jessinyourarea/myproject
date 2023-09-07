package com.sist.web.entity;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

@Entity
@Table(name = "board")
@Getter
@Setter
public class BoardEntity {
    @Id
    private int no;
    private String name,subject,content;
    @Column(insertable = true, updatable = false)
    private String pwd;
    @Column(insertable = true, updatable = false)
    private int hit;
    private String regdate;

    @PrePersist
    public void regdate(){
        this.regdate = LocalDateTime.now().format(DateTimeFormatter.ofPattern("yyyy-MM-dd"));
    }
}
