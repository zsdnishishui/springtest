package aspect;

import org.aspectj.lang.annotation.*;
import org.springframework.context.annotation.Configuration;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class AspectTest {
    @Pointcut("execution(* enity.AopTest.*(..))")
    private void selectAll(){}
    @Before("selectAll()")
    public void beforeAdvice(){
        System.out.println("切面之前");
    }
    @After("selectAll()")
    public void afterAdvice(){
        System.out.println("切面之后");
    }
}
