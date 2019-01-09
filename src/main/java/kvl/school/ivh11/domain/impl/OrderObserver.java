package kvl.school.ivh11.domain.impl;

import kvl.school.ivh11.domain.OrderState;

import java.util.Observable;
import java.util.Observer;

public class OrderObserver implements Observer
{
    @Override
    public void update(Observable o, Object arg)
    {
        final OrderState newState = (OrderState) arg;

        if(newState == OrderState.PAID)
        {
            //mailClient.sendConfirmation
        }
    }
}
