package kvl.school.ivh11.domain.abstr;

import kvl.school.ivh11.domain.impl.MovieOrder;

public interface OrderStateIF
{
    public void processAction(MovieOrder order);
}