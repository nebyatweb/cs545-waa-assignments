package edu.miu.comment.service;

import edu.miu.comment.domain.User;
import edu.miu.comment.domain.dto.PostDto;
import edu.miu.comment.domain.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    void save(User u);
    UserDto findById(int id);
    List<PostDto> findPostById(int id);
    void delete(int id);
}
