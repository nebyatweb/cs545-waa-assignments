package edu.miu.service;

import edu.miu.domain.User;
import edu.miu.domain.dto.PostDto;
import edu.miu.domain.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    void save(User u);
    UserDto findById(int id);
    List<PostDto> findPostById(int id);
    void delete(int id);
    List<UserDto> findUsersByNumberOfPosts(int n);
}
