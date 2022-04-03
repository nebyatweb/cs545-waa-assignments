package edu.miu.user.service;


import edu.miu.user.domain.Post;
import edu.miu.user.domain.dto.PostDto;

import java.util.List;

public interface PostService {
    List<PostDto> findAll();
    void addPost(PostDto p);
}
