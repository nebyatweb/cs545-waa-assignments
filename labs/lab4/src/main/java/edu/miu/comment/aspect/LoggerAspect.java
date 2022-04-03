package edu.miu.comment.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class LoggerAspect {
    @Pointcut("execution(* miu.edu.comment.controller.ProductController.*(..))")
    public void logMeExecution(){

    }
}
