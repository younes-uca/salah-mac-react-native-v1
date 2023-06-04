package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.StatusPaymentDemandHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusPaymentDemandHistoryDao extends AbstractHistoryRepository<StatusPaymentDemandHistory,Long> {

}
