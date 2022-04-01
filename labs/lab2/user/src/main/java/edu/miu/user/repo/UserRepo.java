package edu.miu.user.repo;

import edu.miu.user.domain.User;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface UserRepo extends CrudRepository<User, Integer> {
    List<User> findAll();
}
