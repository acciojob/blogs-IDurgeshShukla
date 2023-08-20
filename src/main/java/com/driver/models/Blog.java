package com.driver.models;


import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table
public
class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Integer blogId;

    public Integer getBlogId() {
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

    private String title;

    private String content;

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

    public Blog(String title, String content, User user) {
        this.title = title;
        this.content = content;
        this.user = user;
    }
}