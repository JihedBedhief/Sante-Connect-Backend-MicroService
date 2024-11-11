package tn.microservices.Blog.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.microservices.Blog.Entities.Post;

@Repository
public interface PostRepository extends JpaRepository<Post,Long> {
}