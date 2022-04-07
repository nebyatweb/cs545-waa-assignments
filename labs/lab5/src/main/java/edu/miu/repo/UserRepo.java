package edu.miu.repo;

import edu.miu.domain.User;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
@Repository
public interface UserRepo extends CrudRepository<User, Integer> {
    List<User> findAll();
    @Query("SELECT u FROM User u WHERE u.posts.size > :n")
    List<User> findByPostsGreaterThan(int n);
    User findByEmail(String email);
}
