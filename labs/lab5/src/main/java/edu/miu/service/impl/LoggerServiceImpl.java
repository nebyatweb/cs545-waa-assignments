package edu.miu.service.impl;

import edu.miu.domain.Logger;
import edu.miu.repo.LoggerRepo;
import edu.miu.service.LoggerService;
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
