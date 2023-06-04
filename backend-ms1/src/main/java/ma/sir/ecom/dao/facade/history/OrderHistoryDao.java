package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.OrderHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderHistoryDao extends AbstractHistoryRepository<OrderHistory,Long> {

}
