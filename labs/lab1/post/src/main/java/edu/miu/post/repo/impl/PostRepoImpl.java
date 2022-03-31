package edu.miu.post.repo.impl;

import edu.miu.post.domain.Post;
import edu.miu.post.repo.PostRepo;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class PostRepoImpl implements PostRepo {
    static List<Post> posts;
    static {
        posts = new ArrayList<>();
        posts.add(new Post(111, "Title", "Content", "Author"));
        posts.add(new Post(112, "Title2", "Content2", "Author2"));
        posts.add(new Post(113, "Title3", "Content3", "Author3"));
    }
    @Override
    public List<Post> findAll() {
        return posts;
    }

    @Override
    public Post findByID(long id) {
        return posts.stream().filter(p -> id == p.getId()).findFirst().orElse(null);
    }

    @Override
    public void save(Post p) {
        posts.add(p);
    }

    @Override
    public void update(Post p) {
        Post p1 = posts.stream().filter(e -> e.getId() == p.getId()).findFirst().orElse(null);
        if(p1 != null){
            p1.setId(p.getId());
            p1.setTitle(p.getTitle());
            p1.setAuthor(p.getAuthor());
            p1.setContent(p.getContent());
        }
    }

    @Override
    public void delete(long id) {
        Post p1 = findByID(id);
        if(p1 != null){
            posts.remove(p1);
        }
    }


}
