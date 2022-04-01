package edu.miu.user.service;

import edu.miu.user.domain.User;
import edu.miu.user.domain.dto.PostDto;
import edu.miu.user.domain.dto.UserDto;

import java.util.List;

public interface UserService {
    List<UserDto> findAll();
    void save(User u);
    UserDto findById(int id);
    List<PostDto> findPostById(int id);
}
