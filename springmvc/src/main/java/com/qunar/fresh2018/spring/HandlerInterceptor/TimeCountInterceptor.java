package com.qunar.fresh2018.spring.HandlerInterceptor;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.aspectj.lang.reflect.MethodSignature;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;


/**
 * @author sht
 */
@Component
@Aspect
public class TimeCountInterceptor {
    private final static Logger logger = LoggerFactory.getLogger(TimeCountInterceptor.class);

    @Pointcut("execution(* com.qunar.fresh2018.spring.dao.DaoImpl.*(..))")
    public void pointcutName() {
    }

    @Around("pointcutName()")
    public Object aroundCount(ProceedingJoinPoint pjt) {
        // 定义返回对象、得到方法需要的参数
        Object obj = null;
        Object[] args = pjt.getArgs();
        long startTime = System.currentTimeMillis();
        try {
            obj = pjt.proceed(args);
        } catch (Throwable e) {
            logger.error("统计某方法执行耗时环绕通知出错", e);
        }
        long endTime = System.currentTimeMillis();
        MethodSignature signature = (MethodSignature) pjt.getSignature();
        String methodName = signature.getDeclaringTypeName() + "." + signature.getName();
        // 打印耗时的信息
        logger.info(methodName + "执行时长: " + (endTime - startTime));
        return obj;

    }

}

