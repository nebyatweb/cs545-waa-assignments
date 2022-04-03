package edu.miu.user.service.impl;


import edu.miu.user.domain.Post;
import edu.miu.user.domain.User;
import edu.miu.user.domain.dto.PostDto;
import edu.miu.user.helper.ListMapper;
import edu.miu.user.repo.PostRepo;
import edu.miu.user.service.PostService;
import edu.miu.user.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;

    @Autowired
    ListMapper listMapper;

    @Autowired
    ListMapper<Post, PostDto> listMapperPostToDto;

    @Autowired
    UserService userService;

    @Override
    public List<PostDto> findAll() {
        return (List<PostDto>)listMapperPostToDto.mapList(postRepo.findAll(),new PostDto());
    }

    @Override
    public void addPost(PostDto p) {
        Post pp = new Post();
        pp.setAuthor(p.getAuthor());
        pp.setContent(p.getContent());
        pp.setTitle(p.getTitle());
        User user = userService.getUserById(p.getUserId());
        user.addPost(pp);
        postRepo.save(pp);
    }
}
