package kvl.school.ivh11.service.impl;

import kvl.school.ivh11.service.abstr.CommunicationData;

public class EmailData extends CommunicationData
{
    private String reciever;
    private String message;
    private String sender;

    public void setReceiver(String receiver) { this.reciever = receiver; }
    public void setMessage(String message) { this.message = message; }
    public void setSender(String sender) { this.sender = sender; }

    public String getReciever() { return reciever; }
    public String getMessage() { return message; }
    public String getSender() { return sender; }
}
