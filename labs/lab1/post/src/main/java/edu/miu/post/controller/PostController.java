package edu.miu.post.controller;

import edu.miu.post.domain.Post;
import edu.miu.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/posts")
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping
    public List<Post> getPosts(){
        return postService.getPosts();
    }

    @GetMapping("/{id}")
    public Post getById(@PathVariable long id){
        return postService.getByID(id);
    }

    @PostMapping
    public void addPost(@RequestBody Post p) {
        postService.add(p);
    }

    @PutMapping
    public void updatePost(@RequestBody Post p) {
        postService.update(p);
    }

    @DeleteMapping("/{id}")
    public void deletePost(@PathVariable long id) {
        postService.delete(id);
    }
}