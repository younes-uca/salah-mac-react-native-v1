package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.OrderStatusOrderHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusOrderHistoryDao extends AbstractHistoryRepository<OrderStatusOrderHistory,Long> {

}
