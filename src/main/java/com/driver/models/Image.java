package com.driver.models;

import javax.persistence.*;

@Entity
@Table
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private Integer blogId;

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Image(Integer id, Integer blogId, String description, String dimensions, Blog blog) {
        this.id = id;
        this.blogId = blogId;
        this.description = description;
        this.dimensions = dimensions;
        this.blog = blog;
    }

    private String description;
    private String dimensions;
    @ManyToOne
    @JoinColumn
    private Blog blog;

    public Image(Blog blog, String description, String dimensions) {
        this.blog = blog;
        this.dimensions =dimensions;
        this.description = description;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public Image() {
    }

    public Image( String description, String dimensions) {
        this.description = description;
        this.dimensions = dimensions;
    }
}