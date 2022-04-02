package edu.miu.comment.repo;

import edu.miu.comment.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Integer> {
    List<User> findAll();
    List<User> findByPostsGreaterThan(int n);
}
