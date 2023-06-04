package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.AccountingOperationHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingOperationHistoryDao extends AbstractHistoryRepository<AccountingOperationHistory,Long> {

}
