package edu.miu.comment.service;

import edu.miu.comment.domain.Post;
import edu.miu.comment.domain.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();
    void addPost(Post p);
}
