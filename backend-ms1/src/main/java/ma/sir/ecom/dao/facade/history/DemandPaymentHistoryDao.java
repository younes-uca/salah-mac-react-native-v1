package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.DemandPaymentHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface DemandPaymentHistoryDao extends AbstractHistoryRepository<DemandPaymentHistory,Long> {

}
