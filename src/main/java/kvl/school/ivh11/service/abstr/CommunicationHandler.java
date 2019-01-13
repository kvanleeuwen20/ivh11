package kvl.school.ivh11.service.abstr;

public abstract class CommunicationHandler
{
    protected CommunicationData data;

    public void CommunicationHandler()
    {
        setReceiver();
        setContent();
        send();
    }

    protected abstract void setReceiver();

    protected abstract void setContent();

    protected abstract void send();
}
