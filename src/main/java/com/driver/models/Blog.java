package com.driver.models;


import javax.persistence.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public
class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer blogId;

    public Integer getId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Blog(Integer blogId, String title, String content, User user) {
        this.blogId = blogId;
        this.title = title;
        this.content = content;
        this.user = user;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public LocalDate getPubDate() {
        return pubDate;
    }

    private String title;

    private String content;

    private LocalDate pubDate;
    @ManyToOne
    @JoinColumn(name = "userId")
    private User user;

    public List<Image> getImageList() {
        return imageList;
    }

    public void setImageList(List<Image> imageList) {
        this.imageList = imageList;
    }

    @OneToMany(mappedBy = "blog", cascade =  CascadeType.ALL)
    private List<Image> imageList = new ArrayList<>();
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

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Blog() {
    }

    public void setPubDate(LocalDate pubDate) {
        this.pubDate = pubDate;
    }

    public Blog(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
        this.pubDate = LocalDate.now();
    }
}