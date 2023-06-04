package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.PaymentMethodHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface PaymentMethodHistoryDao extends AbstractHistoryRepository<PaymentMethodHistory,Long> {

}
