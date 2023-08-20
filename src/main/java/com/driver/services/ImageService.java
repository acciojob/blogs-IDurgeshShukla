package com.driver.services;

import com.driver.models.Blog;
import com.driver.models.Image;
import com.driver.repositories.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ImageService {

    @Autowired
    BlogRepository blogRepository;
    @Autowired
    ImageRepository imageRepository;

    public Image addImage(Integer blogId, String description, String dimensions) throws Exception{
        //add an image to the blog
       Image image = new Image(description,dimensions);
       Optional<Blog> blogOptional = blogRepository.findById(blogId);
       if(!blogOptional.isPresent()) throw new Exception();
       Blog blog = blogOptional.get();
       blog.getImageList().add(image);
       image.setBlog(blog);
       imageRepository.save(image);
       return image;
    }

    public void deleteImage(Integer id){
        if (imageRepository.existsById(id)) imageRepository.deleteById(id);
    }

    public int countImagesInScreen(Integer id, String screenDimensions) throws Exception {
        //Find the number of images of given dimensions that can fit in a screen having `screenDimensions`
        Optional<Image> optionalImage = imageRepository.findById(id);
        if(!optionalImage.isPresent()) throw new Exception("invalid id");
        Image image = optionalImage.get();
        String []arr = image.getDimensions().split("X");
        int  width = Integer.parseInt(arr[0]);
        int height = Integer.parseInt(arr[1]);
        int d = width*height;
        String screen[] = screenDimensions.split("X");
        int w = Integer.parseInt(screen[0]);
        int h = Integer.parseInt(screen[1]);
        int screend = w*h;
        return d/screend;

    }
}
