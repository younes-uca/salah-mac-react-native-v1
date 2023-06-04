package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.CreditNotePurchaseHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface CreditNotePurchaseHistoryDao extends AbstractHistoryRepository<CreditNotePurchaseHistory,Long> {

}
