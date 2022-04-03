package edu.miu.comment.repo;

import edu.miu.comment.domain.Post;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface PostRepo extends CrudRepository<Post, Integer> {
    List<Post> findAll();
//    @Query("SELECT p FROM Post p WHERE p.title = :title")
    List<Post> findAllByTitleIgnoreCase(String title);
}
