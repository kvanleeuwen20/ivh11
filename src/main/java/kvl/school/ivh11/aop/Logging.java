package kvl.school.ivh11.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

@Aspect
public class Logging
{
    @AfterThrowing(pointcut = "execution(* kvl.school.ivh11.*(..))", throwing = "error")
    public void logException(JoinPoint jp, Throwable error)
    {
        Logger.Log(error.getLocalizedMessage());
    }
}
