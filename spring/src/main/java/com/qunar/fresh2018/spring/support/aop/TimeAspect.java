package com.qunar.fresh2018.spring.support.aop;

import lombok.extern.slf4j.Slf4j;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

/**
 * 记录dao层方法访问时长
 */
@Slf4j @Aspect @Component public class TimeAspect {
    @Pointcut("execution( * com.qunar.fresh2018.spring.dao.*.*(..))") public void aspect() {
    }

    @Around("aspect()") public Object around(ProceedingJoinPoint joinPoint) throws Throwable {
        long start = System.currentTimeMillis();
        try {

            Object object = joinPoint.proceed();
            long end = System.currentTimeMillis();
            log.info("执行 " + joinPoint.getSignature().getName() + "\t时长 : " + (end - start) + " ms!");
            return object;
        } catch (Throwable e) {
            log.error(e.getMessage(), e);
            long end = System.currentTimeMillis();
            log.info(
                    "around " + joinPoint + "\tUse time : " + (end - start) + " ms with exception : " + e.getMessage());
            throw e;
        }
    }

}