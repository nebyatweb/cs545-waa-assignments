package edu.miu.post.repo;

import edu.miu.post.domain.Post;

import java.util.List;

public interface PostRepo {
    List<Post> findAll();
    Post findByID(long id);
    void save(Post p);
    void update(Post p);
    void delete(long id);
}
