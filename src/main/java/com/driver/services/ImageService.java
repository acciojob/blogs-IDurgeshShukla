package com.driver.services;

import com.driver.models.*;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository2;
    @Autowired
    ImageRepository imageRepository2;

    public Image addImage(Integer blogId, String description, String dimensions){
        //add an image to the blog
        Optional<Blog> optionalBlog = blogRepository2.findById(blogId);
        Blog blog = optionalBlog.get();
        Image image = new Image(blog,description,dimensions);
        image.setBlog(blog);

        blog.getImageList().add(image);
        blogRepository2.save(blog);
        return imageRepository2.save(image);
    }

    public void deleteImage(Integer id){
        imageRepository2.deleteById(id);

    }

    public int countImagesInScreen(Integer id, String screenDimensions) {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        int count = 0;
        Optional<Image> imageOptional = imageRepository2.findById(id);
        Image image = imageOptional.get();

        String imagedimensions = image.getDimensions();
        String dimensions[] = imagedimensions.split("X");

        String img[]= imagedimensions.split("X");
        String screen[] = screenDimensions.split("X");
        int imagewidth = Integer.parseInt(img[0]);
        int imagehight = Integer.parseInt(img[1]);
        int screenswidth = Integer.parseInt(screen[0]);
        int screenhight = Integer.parseInt(screen[1]);
        return (screenhight/imagehight)*(screenswidth/imagewidth);
    }
}
