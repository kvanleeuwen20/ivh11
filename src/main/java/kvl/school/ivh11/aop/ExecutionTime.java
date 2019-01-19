package kvl.school.ivh11.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class ExecutionTime
{
    @Pointcut("@annotation(sample.web.ui.crosscutting.MyExecutionTime) && execution(* sample.web.ui..*(..))") // the pointcut expression

    public void ExecutionTimeAnnotation()
    {
        // the pointcut signature
    }

    @Around("ExecutionTimeAnnotation()")
    public Object myExecutionTimeAdvice( ProceedingJoinPoint joinPoint /*, MyExecutionTime annotation */) throws Throwable
    {
        long startMillis = System.currentTimeMillis();
        System.out.println("(AOP-myExecTime) Starting timing method " + joinPoint.getSignature());
        Object retVal = joinPoint.proceed();
        long duration = System.currentTimeMillis() - startMillis;
        System.out.println("(AOP-myExecTime) Call to " + joinPoint.getSignature() + " took " + duration + " ms");
        return retVal;
    }
}