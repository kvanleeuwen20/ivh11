package kvl.school.ivh11.domain.impl;

import kvl.school.ivh11.domain.Order;
import kvl.school.ivh11.domain.OrderState;

import kvl.school.ivh11.domain.abstr.OrderObserver;
import kvl.school.ivh11.service.abstr.CommunicationHandler;
import kvl.school.ivh11.service.impl.EmailData;
import kvl.school.ivh11.service.impl.EmailHandler;

import java.util.Observable;

public class OrderObserverImpl extends OrderObserver
{
   @Override
    public void update(Observable o, Object arg)
    {
        final Order newState = (Order) arg;

        if(order.getState() == OrderState.PAID)
        {
            EmailData emailData = new EmailData();
            emailData.setReceiver(order.getCustomer().getEmail());
            emailData.setSender("tickets@kvlcinema.nl");
            emailData.setSender("Your payment was received" );
            CommunicationHandler email = new EmailHandler(emailData);
            email.send();
        }
    }
}
