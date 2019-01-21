package kvl.school.ivh11.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterThrowing;
import org.aspectj.lang.annotation.Aspect;

import java.time.LocalDateTime;

@Aspect
public final class Logging
{
    @AfterThrowing(pointcut = "execution(* kvl.school.ivh11.*(..))", throwing = "error")
    public void logException(JoinPoint jp, Throwable error)
    {
        LocalDateTime date = LocalDateTime.now();

        Logger.getInstance().log(date.getYear()+"-"+date.getMonthValue()+"-"+date.getDayOfMonth()+", path: "+jp.getSourceLocation()+" error: "+error.getLocalizedMessage());
    }
}
