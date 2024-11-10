package tn.microservices.Blog.Entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import tn.microservices.Blog.Dto.CommentDto;

import java.util.Date;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Comment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long codeComment ;
    private String comment;
    private byte[] image;
    private Date date;
    @ManyToOne
    private Post post;
    private String user ;
    private boolean confirmed;





    public CommentDto toDto() {
        CommentDto commentDto = new CommentDto();
        commentDto.setComment(this.comment);
        commentDto.setDate(this.date);
        commentDto.setConfirmed(this.confirmed);
        return commentDto;
    }

    public void setPost(Post post) {
    }

    //private List<String> userList = new ArrayList<>();


}