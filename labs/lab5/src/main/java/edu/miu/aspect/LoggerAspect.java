package edu.miu.aspect;

import edu.miu.domain.Logger;
import edu.miu.service.LoggerService;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.time.LocalTime;

@Aspect
@Component
public class LoggerAspect {
    @Autowired
    LoggerService loggerService;

    @Pointcut("@annotation(edu.miu.aspect.annotation.ExecutionTime)")
    public void logMeAnnotation(){ }

    @Pointcut("execution(* edu.miu.service.impl.CommentServiceImpl.*(..)) || " +
            "execution(* edu.miu.service.impl.UserServiceImpl.*(..)) || " +
            "execution(* edu.miu.service.impl.PostServiceImpl.*(..)) || " +
            "execution(* edu.miu.service.impl.AuthServiceImpl.*(..)) || " +
            "execution(* edu.miu.service.impl.AwesomeUserDetailsService.*(..))")
    public void logService(){}

//    @Pointcut("execution(* edu.miu.comment.service.impl.PostServiceImpl.*(..))")
//    public void logPostService(){}
//
//    @Pointcut("execution(* edu.miu.comment.service.impl.UserServiceImpl.*(..))")
//    public void logUserService(){}

    @After("logService()")
    public void logAfter(JoinPoint joinPoint){
        Logger logger = new Logger();
        logger.setDate(LocalDate.now());
        logger.setTime(LocalTime.now());
        double random = Math.random()*100;
        logger.setPrinciple((long)random);
        logger.setOperation(joinPoint.getTarget().getClass().getSimpleName() + " > " + joinPoint.getSignature().getName());
        loggerService.addLog(logger);
    }


    @Around("logMeAnnotation()")
    public void logMeExecution(ProceedingJoinPoint proceedingJoinPoint) throws Throwable{
        long executionStartTime = System.currentTimeMillis();
        proceedingJoinPoint.proceed();
        long executionEndTime = System.currentTimeMillis();
        System.out.println("Execution time of " + proceedingJoinPoint.getSignature().getName() + " is "
                + (executionEndTime-executionStartTime));
    }
}
