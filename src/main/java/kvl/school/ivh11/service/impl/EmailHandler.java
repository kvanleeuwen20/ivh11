package kvl.school.ivh11.service.impl;

import kvl.school.ivh11.service.abstr.CommunicationHandler;

public class EmailHandler extends CommunicationHandler
{
    private EmailData data;

    public EmailHandler(EmailData data)
    {
        this.data = data;
    }

    @Override
    protected void setReceiver()
    {

    }

    @Override
    protected void setContent()
    {

    }

    @Override
    protected void send()
    {

    }
}
