package kvl.school.ivh11.domain.impl;

import kvl.school.ivh11.components.Messages;
import kvl.school.ivh11.domain.Order;
import kvl.school.ivh11.domain.OrderState;
import kvl.school.ivh11.domain.abstr.OrderStateIF;
import kvl.school.ivh11.service.abstr.CommunicationHandler;
import kvl.school.ivh11.service.impl.SmsData;
import kvl.school.ivh11.service.impl.SmsHandler;
import org.springframework.beans.factory.annotation.Autowired;

import javax.naming.Context;
import java.util.Locale;

public class OrderPaid implements OrderStateIF
{
    @Autowired
    Messages message;
    @Override
    public void processAction(MovieOrder order)
    {

        String messageData[] = {order.getOrder().getCustomer().getName(), String.valueOf(order.getOrder().getId())};
        String msg = message.get("smsMessage.sendOrderNotificationWherePaid", messageData, Locale.ENGLISH);

        SmsData data = new SmsData();
        data.setMessage(msg);
        data.setReceiver(order.getOrder().getCustomer().getMobNr());
        CommunicationHandler cm = new SmsHandler(data);
        cm.send();

        order.getOrder().setState(new OrderCompleted());
    }
}
