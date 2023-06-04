package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.OrderStatusHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderStatusHistoryDao extends AbstractHistoryRepository<OrderStatusHistory,Long> {

}
