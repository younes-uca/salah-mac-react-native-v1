package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.AccountingClassHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingClassHistoryDao extends AbstractHistoryRepository<AccountingClassHistory,Long> {

}
