package kvl.school.ivh11.domain.abstr;

import kvl.school.ivh11.domain.Order;

import java.util.Observer;

public abstract class OrderObserver implements Observer
{
    protected Order order;
}