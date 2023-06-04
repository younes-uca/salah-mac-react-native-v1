package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.OrderItemHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderItemHistoryDao extends AbstractHistoryRepository<OrderItemHistory,Long> {

}
