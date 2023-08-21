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
        Image image = new Image(description,dimensions);
        image.setBlog(blog);
        imageRepository2.save(image);
        blog.getImageList().add(image);
        return image;
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
        int d = Integer.parseInt(dimensions[0])*Integer.parseInt(dimensions[1]);
        String size[] = screenDimensions.split("X");
        int s = Integer.parseInt(size[0])*Integer.parseInt(size[1]);
        return s/d;


    }
}
