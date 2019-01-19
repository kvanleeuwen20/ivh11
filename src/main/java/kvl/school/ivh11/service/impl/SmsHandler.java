package kvl.school.ivh11.service.impl;

import kvl.school.ivh11.service.abstr.CommunicationHandler;

public class SmsHandler extends CommunicationHandler
{
    private SmsData data;

    public SmsHandler(SmsData data) {
        super(data);
    }

    @Override
    protected void setReceiver()
    {
        if(data.getReciever().length() > 9)
            this.data.setReceiver(data.getReciever());
    }

    @Override
    protected void setContent()
    {
        if(data.getMessage().length() > 9)
            this.data.setMessage(data.getMessage());
    }

    protected void setSender()
    {
        if(data.getSender().length() > 2)
            this.data.setSender(data.getSender());
    }
}