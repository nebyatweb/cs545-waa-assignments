package edu.miu.comment.service.impl;

import edu.miu.comment.aspect.annotation.ExecutionTime;
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
import java.util.Optional;

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

    @ExecutionTime
    @Override
    public UserDto findById(int id) {
        Optional<User> optionalUser = userRepo.findById(id);
        if(optionalUser.isPresent()) {
            return  modelMapper.map(optionalUser.get(), UserDto.class);
        }
        return null;
    }

    @Override
    public List<PostDto> findPostById(int id) {
        Optional<User> optionalPost = userRepo.findById(id);
        if(optionalPost.isPresent()) {
            return listMapper.mapList(optionalPost.get().getPosts(), new PostDto());
        }
        return null;
    }

    @Override
    public void delete(int id) {
        userRepo.deleteById(id);
    }

    public List<UserDto> findUsersByNumberOfPosts(int n){
        return listMapper.mapList(userRepo.findByPostsGreaterThan(n), new UserDto());
    }
}
