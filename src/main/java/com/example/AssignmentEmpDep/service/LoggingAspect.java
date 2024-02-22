package com.example.AssignmentEmpDep.service;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;



@Aspect
@Component
public class LoggingAspect {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());


    @Before("execution(* com.example.AssignmentEmpDep.service.EmpServiceImpl.saveEmp(..))")
    public void logBefore(JoinPoint joinPoint) {
        logger.info("Received request: Save Emp =====> " + joinPoint.getSignature().toShortString());
    }

//    @AfterReturning(pointcut = "execution(* com.example.*.*.*(..))", returning = "result")
    @AfterReturning(pointcut = "execution(* com.example.AssignmentEmpDep.service.EmpServiceImpl.saveEmp()))", returning = "result")
    public void logAfter(JoinPoint joinPoint, Object result) {
        logger.info("Response: " + result);
    }



}
