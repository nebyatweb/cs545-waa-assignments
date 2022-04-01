package edu.miu.user.repo;

import edu.miu.user.domain.Post;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

public interface PostRepo extends CrudRepository<Post, Integer> {
    List<Post> findAll();
}
