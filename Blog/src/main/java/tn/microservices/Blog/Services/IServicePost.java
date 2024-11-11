package tn.microservices.Blog.Services;

import tn.microservices.Blog.Dto.PostDto;
import tn.microservices.Blog.Entities.Post;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IServicePost {


    PostDto addPost(PostDto postDto) throws IOException;


    List<PostDto> getAllPosts();

    boolean deletePost(Long id);




    Optional<Post> getPostById(Long id);
}