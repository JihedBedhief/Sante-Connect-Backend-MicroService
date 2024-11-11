package tn.microservices.Blog.Services;

import tn.microservices.Blog.Dto.CommentDto;
import tn.microservices.Blog.Entities.Comment;

import java.io.IOException;
import java.util.List;
import java.util.Optional;

public interface IServiceComment {

    Comment addComment(Comment commentDto, Long postID ) throws IOException;
    public List<CommentDto> getAllComment();
    public boolean deleteComment(Long id);
    public CommentDto updateComment(CommentDto commentDto) throws IOException;
    public Optional<CommentDto> getCommentById(Long id);
    public void acceptComment(Long id);
    public List<CommentDto> getAllCommentsByPostId(Long postId);
}