package edu.miu.comment.controller;

import edu.miu.comment.domain.User;
import edu.miu.comment.domain.dto.PostDto;
import edu.miu.comment.domain.dto.UserDto;
import edu.miu.comment.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public List<UserDto> getUsers(){
        return userService.findAll();
    }

    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    public void addUser(@RequestBody User u) {
        userService.save(u);
    }

    @GetMapping("/{id}")
    public UserDto getUserByID(@PathVariable int id){
        return userService.findById(id);
    }

    @GetMapping("/{id}/posts")
    public List<PostDto> getPostsByUserID(@PathVariable int id){
        return userService.findPostById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable int id) {
        userService.delete(id);
    }

    @GetMapping("/posts")
    public List<UserDto> getUsersByNumberOfPosts(@RequestParam int n){
        return userService.findUsersByNumberOfPosts(n);
    }
}

