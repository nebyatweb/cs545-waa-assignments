package edu.miu.service.impl;

import edu.miu.aspect.annotation.ExecutionTime;
import edu.miu.domain.User;
import edu.miu.domain.dto.PostDto;
import edu.miu.domain.dto.UserDto;
import edu.miu.util.ListMapper;
import edu.miu.repo.UserRepo;
import edu.miu.service.UserService;
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
