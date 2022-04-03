package edu.miu.comment.repo;

import edu.miu.comment.aspect.LoggerAspect;
import edu.miu.comment.domain.Logger;
import org.springframework.data.repository.CrudRepository;

public interface LoggerRepo extends CrudRepository<Logger, Long> {

}
