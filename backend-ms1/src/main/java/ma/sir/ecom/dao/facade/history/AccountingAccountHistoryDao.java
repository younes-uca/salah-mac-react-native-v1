package ma.sir.ecom.dao.facade.history;

import ma.sir.ecom.zynerator.repository.AbstractHistoryRepository;
import ma.sir.ecom.bean.history.AccountingAccountHistory;
import org.springframework.stereotype.Repository;

@Repository
public interface AccountingAccountHistoryDao extends AbstractHistoryRepository<AccountingAccountHistory,Long> {

}
