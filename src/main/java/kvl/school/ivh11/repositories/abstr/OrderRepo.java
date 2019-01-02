package kvl.school.ivh11.repositories.abstr;

import kvl.school.ivh11.domain.Order;
import org.springframework.stereotype.Component;

@Component
public interface OrderRepo extends BaseRepo<Order, Long>
{

}