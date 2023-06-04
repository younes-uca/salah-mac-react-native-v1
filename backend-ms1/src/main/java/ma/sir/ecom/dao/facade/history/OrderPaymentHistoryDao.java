package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.OrderPaymentHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderPaymentHistoryDao extends AbstractHistoryRepository<OrderPaymentHistory,Long> {

}
