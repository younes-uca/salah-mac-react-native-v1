package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.LatePaymentRateHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface LatePaymentRateHistoryDao extends AbstractHistoryRepository<LatePaymentRateHistory,Long> {

}
