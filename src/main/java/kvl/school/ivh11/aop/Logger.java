package kvl.school.ivh11.aop;

public final class Logger
{
    private static Logger loggerInstance = null;

    public static void log(String message)
    {
        loggerInstance.log(message);
    }

    private Logger()
    {
        getInstance();
    }

    //preven thread sync issues
    private synchronized static void createLoggerInstance ()
    {
        if (loggerInstance == null)
            loggerInstance = new Logger();
    }

    public static Logger getInstance()
    {
        if (loggerInstance == null)
            createLoggerInstance();

        return loggerInstance;
    }
}
