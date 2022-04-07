package edu.miu.service.impl;

import edu.miu.domain.Post;
import edu.miu.domain.dto.PostDto;
import edu.miu.util.ListMapper;
import edu.miu.repo.PostRepo;
import edu.miu.service.PostService;
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

    @Override
    public List<PostDto> getPostsByTitle(String title) {
        return (List<PostDto>)listMapperPostToDto.mapList(postRepo.findAllByTitleIgnoreCase(title), new PostDto());
    }
}
