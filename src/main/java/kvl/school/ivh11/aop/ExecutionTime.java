package kvl.school.ivh11.aop;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.stereotype.Component;

@Component
@Aspect
public final class ExecutionTime
{
    @Pointcut("@annotation(kvl.school.ivh11.*)")

    public void ExecutionTimeAnnotation()
    {
        // the pointcut signature
    }

    @Around("ExecutionTimeAnnotation()")
    public Object myExecutionTimeAdvice( ProceedingJoinPoint joinPoint) throws Throwable
    {
        long startMillis = System.currentTimeMillis();
        Logger.Log("(AOP-myExecTime) Starting timing method " + joinPoint.getSignature());
        Object retVal = joinPoint.proceed();
        long duration = System.currentTimeMillis() - startMillis;
        Logger.Log("(AOP-myExecTime) Call to " + joinPoint.getSignature() + " took " + duration + " ms");

        return retVal;
    }
}