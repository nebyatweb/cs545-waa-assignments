package edu.miu.comment.service.impl;

import edu.miu.comment.domain.Logger;
import edu.miu.comment.repo.LoggerRepo;
import edu.miu.comment.service.LoggerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class LoggerServiceImpl implements LoggerService {
    @Autowired
    LoggerRepo loggerRepo;


    @Override
    public void addLog(Logger logger) {
        loggerRepo.save(logger);
    }
}
