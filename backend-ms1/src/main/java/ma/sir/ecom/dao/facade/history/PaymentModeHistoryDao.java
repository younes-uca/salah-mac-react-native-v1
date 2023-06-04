package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.PaymentModeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentModeHistoryDao extends AbstractHistoryRepository<PaymentModeHistory,Long> {

}
