package edu.miu.post.service.impl;

import edu.miu.post.domain.Post;
import edu.miu.post.repo.PostRepo;
import edu.miu.post.service.PostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PostServiceImpl implements PostService {
    @Autowired
    private PostRepo postRepo;

    @Override
    public List<Post> getPosts() {
        return postRepo.findAll();
    }

    @Override
    public Post getByID(long id) {
        return postRepo.findByID(id);
    }

    @Override
    public void add(Post p) {
        postRepo.save(p);
    }

    @Override
    public void update(Post p) {
        postRepo.update(p);
    }

    @Override
    public void delete(long id) {
        postRepo.delete(id);
    }


}
