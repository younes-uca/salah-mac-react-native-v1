package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.AccountingOperationStatusHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingOperationStatusHistoryDao extends AbstractHistoryRepository<AccountingOperationStatusHistory,Long> {

}
