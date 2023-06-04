package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.AccountingOperationTypeHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingOperationTypeHistoryDao extends AbstractHistoryRepository<AccountingOperationTypeHistory,Long> {

}
