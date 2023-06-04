package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.CreditNotePurchaseStatusHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditNotePurchaseStatusHistoryDao extends AbstractHistoryRepository<CreditNotePurchaseStatusHistory,Long> {

}
