package tn.microservices.Blog.Controller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import tn.microservices.Blog.Dto.PostDto;
import tn.microservices.Blog.Entities.Post;
import tn.microservices.Blog.Services.IServicePost;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/Post")
@CrossOrigin(origins = "http://localhost:4200")
public class PostController {

    private final IServicePost servicePost;

    @PostMapping(value = "/addpost",consumes = "multipart/form-data")
    public ResponseEntity<PostDto> addPost(@RequestPart("imagepost") MultipartFile imagepost,
                                           @RequestPart String title,
                                           @RequestPart String description,
                                           @RequestPart String author) throws IOException {
        PostDto postDto= new PostDto();
        postDto.setTitle(title);
        postDto.setDescription(description);
        postDto.setAuthor(author);

        byte[] img=imagepost.getBytes();
        postDto.setImagepost(img);
        PostDto addedPost2 = servicePost.addPost(postDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(addedPost2);
    }
    @GetMapping
    public ResponseEntity<List<PostDto>> getAllPosts() {
        List<PostDto> posts = servicePost.getAllPosts();
        return ResponseEntity.ok(posts);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Post> getPostById(@PathVariable("id") Long id) {
        Optional<Post> optionalPost = servicePost.getPostById(id);
        return optionalPost.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deletePost(@PathVariable("id") Long id) {
        servicePost.deletePost(id);
        return ResponseEntity.noContent().build();
    }
}
