package kvl.school.ivh11.aop;

public class Logger
{
    private static Logger loggerInstance = null;

    public void log(String message)
    {
        loggerInstance.log(message);
    }

    private Logger()
    {
        getInstance();
    }

    private synchronized static void createLoggerInstance ()
    {
        if (loggerInstance == null)
            loggerInstance = new Logger ();
    }

    public static Logger getInstance()
    {
        if (loggerInstance == null)
            createLoggerInstance();

        return loggerInstance;
    }
}
