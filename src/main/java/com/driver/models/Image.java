package com.driver.models;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public
class Image{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer imageId;
   private String dimensions;
   private String description;
   private Date pubdate;

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @ManyToOne
   @JoinColumn(name = "blogId")
   private Blog blog;
    public Image() {
    }

    public Integer getImageId() {
        return imageId;
    }

    public void setId(Integer imageId) {
        this.imageId = imageId;
    }

    public String getDimensions() {
        return dimensions;
    }

    public void setDimensions(String dimensions) {
        this.dimensions = dimensions;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Image( String description,String dimensions) {
        this.dimensions = dimensions;
        this.description = description;
    }

    public Date getPubdate() {
        return pubdate;
    }

    public void setPubdate(Date pubdate) {
        this.pubdate = pubdate;
    }
}