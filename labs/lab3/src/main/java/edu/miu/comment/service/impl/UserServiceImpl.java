package edu.miu.comment.service.impl;

import edu.miu.comment.domain.Post;
import edu.miu.comment.domain.User;
import edu.miu.comment.domain.dto.PostDto;
import edu.miu.comment.domain.dto.UserDto;
import edu.miu.comment.helper.ListMapper;
import edu.miu.comment.repo.UserRepo;
import edu.miu.comment.service.UserService;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    UserRepo userRepo;

    @Autowired
    ListMapper listMapper;

    @Autowired
    ModelMapper modelMapper;

    @Autowired
    ListMapper<User, UserDto> listMapperUserToDto;

    @Override
    public List<UserDto> findAll() {
        return (List<UserDto>)listMapperUserToDto.mapList(userRepo.findAll(),new UserDto());
    }

    @Override
    public void save(User u) {
        userRepo.save(u);
    }

    @Override
    public UserDto findById(int id) {
        return modelMapper.map(userRepo.findById(id).get(), UserDto.class);
    }

    @Override
    public List<PostDto> findPostById(int id) {
        return listMapper.mapList(userRepo.findById(id).get().getPosts(), new PostDto());
    }

    @Override
    public void delete(int id) {
        userRepo.deleteById(id);
    }
}
