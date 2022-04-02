package edu.miu.comment.service.impl;

import edu.miu.comment.domain.Post;
import edu.miu.comment.domain.dto.PostDto;
import edu.miu.comment.helper.ListMapper;
import edu.miu.comment.repo.PostRepo;
import edu.miu.comment.service.PostService;
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

    @Override
    public List<PostDto> findAll() {
        return (List<PostDto>)listMapperPostToDto.mapList(postRepo.findAll(),new PostDto());
    }

    @Override
    public void addPost(Post p) {
        postRepo.save(p);
    }
}
