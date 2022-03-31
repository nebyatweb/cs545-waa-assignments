package edu.miu.post.service;

import edu.miu.post.domain.Post;

import java.util.List;

public interface PostService {
    List<Post> getPosts();
    Post getByID(long id);
    void add(Post p);
    void update(Post p);
    void delete(long id);
}
