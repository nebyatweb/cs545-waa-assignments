package edu.miu.user.controller;

import edu.miu.user.domain.User;
import edu.miu.user.domain.dto.PostDto;
import edu.miu.user.domain.dto.UserDto;
import edu.miu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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
}
