package edu.miu.user.controller;

import edu.miu.user.domain.Post;
import edu.miu.user.domain.dto.PostDto;
import edu.miu.user.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public List<PostDto> getPosts() {
        return postService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addPosts(@RequestBody Post p) {
        postService.addPost(p);
    }
}