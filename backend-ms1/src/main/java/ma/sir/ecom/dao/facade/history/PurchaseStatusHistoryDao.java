package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.PurchaseStatusHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface PurchaseStatusHistoryDao extends AbstractHistoryRepository<PurchaseStatusHistory,Long> {

}
