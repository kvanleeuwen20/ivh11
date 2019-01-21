package kvl.school.ivh11.domain.impl;

import kvl.school.ivh11.components.Messages;
import kvl.school.ivh11.domain.Order;
import kvl.school.ivh11.domain.abstr.OrderStateIF;
import kvl.school.ivh11.service.abstr.CommunicationHandler;
import kvl.school.ivh11.service.impl.SmsData;
import kvl.school.ivh11.service.impl.SmsHandler;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Locale;

public class OrderPaid implements OrderStateIF
{
    @Autowired
    Messages message;
    @Override
    public void processAction(Order order)
    {
        String messageData[] = {order.getCustomer().getName(), String.valueOf(order.getId())};
        String msg = message.get("smsMessage.sendOrderNotificationWherePaid", messageData, Locale.ENGLISH);

        SmsData data = new SmsData();
        data.setMessage(msg);
        data.setReceiver(order.getCustomer().getMobNr());
        CommunicationHandler cm = new SmsHandler(data);
        cm.send();

        order.setState(new OrderCompleted());
    }
}
