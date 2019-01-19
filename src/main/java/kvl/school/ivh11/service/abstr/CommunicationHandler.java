package kvl.school.ivh11.service.abstr;

public abstract class CommunicationHandler
{
    protected CommunicationData data;

    public CommunicationHandler(CommunicationData data)
    {
        this.data = data;
    }

    protected abstract void setReceiver();

    protected abstract void setContent();

    public final void send()
    {
        setReceiver();
        setContent();
    }
}
