package kvl.school.ivh11.aop;

public class Logger
{
    private static Logger _loggerInstance = null;

    public static void Log(String msg)
    {
        System.out.print(msg);
    }

    public Logger()
    {
        getInstance();
    }

    private synchronized static void createLoggerInstance ()
    {
        if (_loggerInstance == null)
            _loggerInstance = new Logger ();
    }

    public static Logger getInstance()
    {
        if (_loggerInstance == null)
            createLoggerInstance();

        return _loggerInstance;
    }
}
