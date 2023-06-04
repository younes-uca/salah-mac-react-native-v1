package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.CreditNotePurchaseItemHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditNotePurchaseItemHistoryDao extends AbstractHistoryRepository<CreditNotePurchaseItemHistory,Long> {

}
