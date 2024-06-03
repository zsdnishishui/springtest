package com.zsd.aspect;

import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectTest {
    @Pointcut("execution(* com.zsd.entity.AopTest.*(..))")
    private void selectAll() {
    }

    @Before("selectAll()")
    public void beforeAdvice() {
        System.out.println("切面之前");
    }

    @After("selectAll()")
    public void afterAdvice() {
        System.out.println("切面之后");
    }
}
