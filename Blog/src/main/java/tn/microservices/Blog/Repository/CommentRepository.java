package tn.microservices.Blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.microservices.Blog.Entities.Comment;

@Repository
public interface CommentRepository extends JpaRepository<Comment,Long> {
}