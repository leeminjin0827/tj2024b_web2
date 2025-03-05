package example.senter.aspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

import java.util.Arrays;

@Aspect
@Component
public class SenterAspect {

    @Around( " execution( * example.senter.service.SenterService.*(..) )")
    public Object SenterCheck(ProceedingJoinPoint joinPoint ) throws Throwable{
        System.out.println("[실행메소드] : " + joinPoint.getSignature() );
        System.out.println("[매개변수] : " + Arrays.toString( joinPoint.getArgs() ) );
        Object result = joinPoint.proceed();
        System.out.println("[반환값] : " + result );
        return result;
    } // f end
} // c end
