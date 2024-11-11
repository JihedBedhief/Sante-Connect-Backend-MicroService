package tn.microservices.Blog.Services;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.microservices.Blog.Dto.PostDto;
import tn.microservices.Blog.Entities.Post;
import tn.microservices.Blog.Repository.PostRepository;

import java.io.IOException;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@Slf4j
@RequiredArgsConstructor
public class ServicePost implements IServicePost {

    @Autowired
    private PostRepository postRepository;

    @Override
    public PostDto addPost(PostDto postDto) throws IOException {
        // Convert PostDto to Post entity
        Post post = new Post();
      //  post.setImagepost(postDto.getImagepost());
        post.setTitle(postDto.getTitle());
        post.setDescription(postDto.getDescription());
        post.setAuthor(postDto.getAuthor());
        post.setDatepost(postDto.getDatepost());
       /// post.setComf(postDto.isComf());
       // post.setUser(postDto.getUser());

        // Save Post entity to the repository
        Post savedPost = postRepository.save(post);

        // Convert the saved Post entity back to PostDto and return
        return savedPost.toDto();
    }
    @Override
    public List<PostDto> getAllPosts() {
        List<Post> posts = postRepository.findAll();
        return posts.stream()
                .map(Post::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public boolean deletePost(Long id) {
        postRepository.deleteById(id);
        return true;
    }



    @Override
    public Optional<Post> getPostById(Long id) {
        Optional<Post> optionalPost = postRepository.findById(id);
        return optionalPost;
    }

    private PostDto convertToDto(Post post) {
        PostDto postDto = new PostDto();
        // Map fields from Reclamation entity to ReclamationDto
        // Map other fields as needed

        return postDto;
    }
}