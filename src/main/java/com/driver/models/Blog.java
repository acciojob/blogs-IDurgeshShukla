package com.driver.models;

import net.minidev.json.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
    private Date pubDate;
    @OneToMany(mappedBy = "blog", cascade = CascadeType.ALL)
    private List<Image> imageList = new ArrayList<>();

    @ManyToOne
    @JsonIgnore
    private User user;

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

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

    public Date getPubDate() {
        return pubDate;
    }

    public void setPubDate(Date pubDate) {
        this.pubDate = pubDate;
    }

    public Blog() {
    }

    public Blog(String title, String content, Date pubDate) {
        this.title = title;
        this.content = content;
        this.pubDate = pubDate;
    }

    public User getUser() {
        return user;
    }

    public Blog(String title, String content) {
        this.title = title;
        this.content = content;
    }

    public void setUser(User user) {
        this.user = user;
    }
}