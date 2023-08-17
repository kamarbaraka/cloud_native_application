package com.kamar.cloud_native_application.components.aspects;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;

import java.time.LocalDateTime;

/**
 * an aspect to log the cat controller execution time.
 * @author kamar baraka.*/

@Aspect
public class CatLogging {

    /*define the logger*/
    private final Log log = LogFactory.getLog(getClass());

    @Around("execution(* com.kamar.cloud_native_application.components.controllers.CatController.*())")
    public Object log(ProceedingJoinPoint joinPoint) throws Throwable{

        /*set the execution start time*/
        LocalDateTime startTime = LocalDateTime.now();

        /*initialize variables */
        Object returnValue = null;
        Throwable exception = null;

        try {
            /*proceed the execution and catch any exception it throws*/
            returnValue = joinPoint.proceed();
        }
        catch (Throwable throwable){
            /*cache the thrown exception*/
            exception = throwable;
        }

        /*set the execution end time*/
        LocalDateTime stopTime = LocalDateTime.now();

        /*rethrow the exception if any*/
        if (exception != null)
            throw exception;

        /*log the execution time*/
        log.info("the execution started at %s".formatted(startTime));
        log.info("the execution ended at %s".formatted(stopTime));
        log.info("duration = %s".formatted(stopTime.minusNanos(startTime.getNano()).getNano()));

        /*return the return value*/
        return returnValue;
    }
}
