package edu.miu.service;

import edu.miu.domain.Post;
import edu.miu.domain.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();
    void addPost(Post p);
    List<PostDto> getPostsByTitle(String title);
}
